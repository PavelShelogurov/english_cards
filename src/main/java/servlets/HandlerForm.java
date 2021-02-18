package servlets;

import model.WordCard;
import model.CardStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;

/**
 * В данном сервлете принимаются данные из формы добавления карточек пост-запросом и добавляются синглтон класс для хранения
 */

@MultipartConfig(location = "D:\\JAVA\\Java_projects\\Servlets\\src\\main\\webapp\\img")
public class HandlerForm extends HttpServlet {
    private static final String IMAGE_TAG = "pic";
    private static final String NATIVE_LANGUAGE_FIELD = "nativeWord";
    private static final String FOREIGN_LANGUAGE_FIELD = "foreignWord";
    private static final String PREFIX_IMAGE_PATH = "img/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Handler of form will be here");
        out.println("Get method");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Post method");
        out.println("Your data saved!");

        Map<String, String[]> parameters = req.getParameterMap();
        //переменные для записи данных из формы
        String nativeLanguage = null;
        String foreignLanguage = null;
        String imgPath = null;

        for (Map.Entry<String, String[]> pair : parameters.entrySet()) {
            switch (pair.getKey()) {
                case NATIVE_LANGUAGE_FIELD:
                    nativeLanguage = createOneString(pair.getValue());
                    break;
                case FOREIGN_LANGUAGE_FIELD:
                    foreignLanguage = createOneString(pair.getValue());
                    break;
            }
        }
        //сохранение изображения и ссылки на изображение для профиля
        for (Part part : req.getParts()) {
            if (part.getName().equals(IMAGE_TAG)) {
                part.write(part.getSubmittedFileName());
                imgPath = PREFIX_IMAGE_PATH + part.getSubmittedFileName();
            }
        }

        WordCard wordCard = new WordCard(nativeLanguage, foreignLanguage, imgPath);

        CardStore cardStore = CardStore.getInstance();
        cardStore.addToCardList(wordCard);

        resp.sendRedirect("worker-list");

        /**
         * новую карточку со словом нужно положить в базу в место синглтон класса
         */

    }

    //чтобы собрать массив значений аргументов в одну строку
    private String createOneString(String[] arrayOfStrings) {
        StringBuilder out = new StringBuilder("");
        for (String str : arrayOfStrings) {
            out.append(str);
        }
        return new String(out);
    }
}

