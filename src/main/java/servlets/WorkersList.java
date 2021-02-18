package servlets;

import model.WordCard;
import model.CardStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WorkersList extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //временно вместо базы данных будет использоваться класс хранящий список со всеми элементами(паттер сингл тон)
        CardStore cardStore = CardStore.getInstance();
        /**
         *Здесь нужно заполнение списка с сотрудниками из базы даннх
         */
        //for testing jsp
        List<WordCard> wordCardList = new ArrayList<>();
        wordCardList.add(new WordCard("Кошка", "Cat", "img/cat.jpg"));
        wordCardList.add(new WordCard("Башня", "Tower", "img/tower.jpg"));
        wordCardList.add(new WordCard("Автомобиль", "Car", "img/car.jpg"));
        wordCardList.addAll(cardStore.getWordCardList());

        //отправляем данные в jsp страницу для отображения
        req.setAttribute("cards", wordCardList);
        getServletContext().getRequestDispatcher("/wordCards.jsp").forward(req, resp);
    }


}
