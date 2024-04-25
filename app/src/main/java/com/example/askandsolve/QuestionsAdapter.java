package com.example.askandsolve;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;




public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder> {

    private ArrayList<Questions> questionList;
    Context context;

    public QuestionsAdapter(ArrayList<Questions> questionList, Context context) {
        this.questionList = questionList;
        this.context = context;
    }



    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.questions_item, parent, false);
        return new QuestionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Questions question = questionList.get(position);

        holder.views.setText(question.getViews().toString());
        holder.votes.setText(question.getVotes().toString());
        holder.title.setText(question.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AnswerQuestion.class);
                intent.putExtra("Title", question.getTitle());
                intent.putExtra("Question_Content",question.getQueContent());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }




    public static class QuestionsViewHolder extends RecyclerView.ViewHolder {
        TextView  views, votes, title, isAnswered;

        public QuestionsViewHolder(@NonNull View itemView) {
            super(itemView);


            views = itemView.findViewById(R.id.view);
            votes = itemView.findViewById(R.id.vote);
            title = itemView.findViewById(R.id.questionTitle);
            isAnswered = itemView.findViewById(R.id.answers);


        }
    }
}

