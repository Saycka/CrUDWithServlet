package com.manyatkin.crudwithservlets.controller;

import com.manyatkin.crudwithservlets.model.MyDataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/delete.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");

        if (!sId.equals("")) {
            int id = Integer.parseInt(sId);
            MyDataBase myDataBase = MyDataBase.getInstance();

            try {
                myDataBase.delete(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        doGet(req, resp);
    }

}
