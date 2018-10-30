package com.manyatkin.crudwithservlets.controller;

import com.manyatkin.crudwithservlets.model.MyDataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        String vendorCode = req.getParameter("vendorCode");
        String name= req.getParameter("name");
        String sCost = req.getParameter("cost");

        if (!sId.equals("") && !sCost.equals("")) {
            MyDataBase myDataBase = MyDataBase.getInstance();

            try {
                myDataBase.update(Integer.parseInt(sId),vendorCode, name, Integer.parseInt(sCost));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        doGet(req, resp);
    }

}
