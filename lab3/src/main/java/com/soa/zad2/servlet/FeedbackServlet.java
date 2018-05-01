package com.soa.zad2.servlet;

import com.soa.zad2.data.FeedbackData;
import lombok.Getter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/zad2_feedback")
public class FeedbackServlet extends HttpServlet {

    private static final String FEEDBACK_VIEW = "WEB-INF/view/zad2/jsp/Feedback.jsp";

    @Getter
    private final List<FeedbackData> feedbacks = new LinkedList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        insertTestData();
        request.setAttribute("feedbacks", feedbacks);
        RequestDispatcher view = request.getRequestDispatcher(FEEDBACK_VIEW);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FeedbackData feedback = buildFeedbackData(request);
        feedbacks.add(feedback);
    }

    private void insertTestData(){
        feedbacks.add(FeedbackData.builder()
                .name("name")
                .email("email")
                .comment("comment")
                .build());

        feedbacks.add(FeedbackData.builder()
                .name("name1")
                .email("email1")
                .comment("comment1")
                .build());

        feedbacks.add(FeedbackData.builder()
                .name("name2")
                .email("email2")
                .comment("comment2")
                .build());
    }

    private FeedbackData buildFeedbackData(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String comment = request.getParameter("comment");

        return FeedbackData.builder()
                .name(name)
                .email(email)
                .comment(comment)
                .build();
    }
}
