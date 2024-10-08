package com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.adapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.R;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.customclasses.AppControl;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.customclasses.Constant;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.model.LearningDataModel;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.utils.Utils;

import java.util.ArrayList;


public class ListenGuessAdapter extends RecyclerView.Adapter<ListenGuessAdapter.ViewHolder> {


    Context context;
    ArrayList<LearningDataModel> examQuestionAnswerList;
    LearningDataModel learningDataModel;

    public ListenGuessAdapter(Context context, ArrayList<LearningDataModel> examQuestionAnswerList, LearningDataModel learningDataModel) {
        this.context = context;
        this.examQuestionAnswerList = examQuestionAnswerList;
        this.learningDataModel = learningDataModel;
    }


//    TextToSpeech textToSpeech;

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        LinearLayout lloutExamAnswer;
        ImageView iVExamAnswer;

        ViewHolder(@NonNull View view) {
            super(view);
            this.cardView = (CardView) view.findViewById(R.id.cvCardSubHome);
            this.iVExamAnswer = (ImageView) view.findViewById(R.id.iVExamAnswer);
            this.lloutExamAnswer = (LinearLayout) view.findViewById(R.id.lloutExamAnswer);
//            textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
//                @Override
//                public void onInit(int status) {
//                    if (status != TextToSpeech.ERROR) {
//                        textToSpeech.setLanguage(Locale.UK);
//                    }
//                }
//            });
        }
    }


    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_exam_phonics, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Glide.with(context).load(examQuestionAnswerList.get(i).image).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)).into(viewHolder.iVExamAnswer);
        viewHolder.cardView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.bubble_anim));

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (learningDataModel.showTitle.equals(examQuestionAnswerList.get(i).showTitle)) {
                    Toast.makeText(context, "Correct Answer", Toast.LENGTH_SHORT).show();
                    viewHolder.lloutExamAnswer.setBackgroundColor(context.getResources().getColor(R.color.colorCorrect));
                    if (Utils.getPref(Constant.SOUND,true)) {
                        AppControl.textToSpeech.speak("Correct Answer", TextToSpeech.QUEUE_FLUSH, null);
                    }
                } else {
                    Toast.makeText(context, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    viewHolder.lloutExamAnswer.setBackgroundColor(context.getResources().getColor(R.color.colorWrong));
                    if (Utils.getPref(Constant.SOUND,true)) {
                        AppControl.textToSpeech.speak("Wrong Answer", TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
            }
        });
    }

    public int getItemCount() {
        return examQuestionAnswerList.size();
    }
}