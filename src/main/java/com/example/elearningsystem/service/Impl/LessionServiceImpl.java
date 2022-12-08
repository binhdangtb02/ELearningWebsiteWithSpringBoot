package com.example.elearningsystem.service.Impl;

import com.example.elearningsystem.model.Lession;
import com.example.elearningsystem.model.Question;
import com.example.elearningsystem.model.Word;
import com.example.elearningsystem.repository.LessionRepository;
import com.example.elearningsystem.service.ILessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LessionServiceImpl implements ILessionService {
    private final LessionRepository lessionRepository;
    public Collection<Word> viewWordsByLesson(Long lessonid) {
        return lessionRepository.findById(lessonid).orElseGet(() -> null).getWords();
    }
@Override
    public ArrayList<Question> createTest(Long lessionid){

        Collection<Word> wordsCollection = lessionRepository.findById(lessionid).orElseGet(() -> null).getWords();
    Word[] words = wordsCollection.toArray(new Word[wordsCollection.size()]);
        int size =  wordsCollection.size();
        ArrayList<Question> questions = new ArrayList<>();
        for(int i =0; i<size;i++){
            Question question =  new Question();
            question.setTerm(words[i].getTerm());
            question.setAnswer(words[i].getDefinition());
            String[] definitions = new String[4];
            int[] arrayRandom =  new int[3];

            for(int j=0;j<3;j++){


                while(true){
                    int random  =  (int)Math.floor(Math.random()*size);
                   if(random == i){
                       continue;
                   }
                   int check = 0;
                   for (int k =0;k<j;k++){
                       System.out.println(k + " " + arrayRandom[k]);
                       if(arrayRandom[k] == random){
                           check = 1;
                       }
                   }
                   if(check == 1){
                       continue;
                   }

                  arrayRandom[j] = random;
                   break;
                }
//                System.out.println(arrayRandom[j]);
                definitions[j] = words[arrayRandom[j]].getDefinition();
            }
            definitions[3] = words[i].getDefinition();
            question.setDefinitions(definitions);
            questions.add(question);

        }
        return questions;
    }
}
