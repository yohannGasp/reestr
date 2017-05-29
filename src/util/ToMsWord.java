/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;

/**
 *
 * @author evgeniy
 */
public class ToMsWord {

    String namefile;

    /**
     *
     * @param namefile
     */
    public void setNamefile(String namefile) {
        this.namefile = namefile;
    }

    public void process(List<?> param, Map<String, String> parameters) {

        XWPFDocument doc = new XWPFDocument();
        
        
        // https://stackoverflow.com/questions/20188953/how-to-set-page-orientation-for-word-document
        CTDocument1 document = doc.getDocument();
        CTBody body = document.getBody();
        if (!body.isSetSectPr()) {
            body.addNewSectPr();
        }
        CTSectPr section = body.getSectPr();
        if (!section.isSetPgSz()) {
            section.addNewPgSz();
        }
        CTPageSz pageSize = section.getPgSz();
        pageSize.setOrient(STPageOrientation.LANDSCAPE);
        pageSize.setW(BigInteger.valueOf(15840));
        pageSize.setH(BigInteger.valueOf(12240));

        /**
         * h1
         */
        XWPFParagraph p1 = doc.createParagraph();
        p1.setAlignment(ParagraphAlignment.RIGHT);
        p1.setVerticalAlignment(TextAlignment.CENTER);

        XWPFRun r1 = p1.createRun();
        r1.setText("Приложение №5 к Договору на организацию");
        r1.setText("зарплатного проекта");
        r1.setFontFamily("Times New Roman");
        r1.setFontSize(10);
        r1.addBreak(BreakType.TEXT_WRAPPING);
        r1.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2
         */
        XWPFParagraph p2 = doc.createParagraph();
        p2.setAlignment(ParagraphAlignment.CENTER);
        p2.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r2 = p2.createRun();
        r2.setText("Наименование Организации	_____________________________:");
        r2.setFontFamily("Times New Roman");
        r2.setFontSize(12);
        r2.addBreak(BreakType.TEXT_WRAPPING);
        r2.addBreak(BreakType.TEXT_WRAPPING);
        
        XWPFParagraph p3 = doc.createParagraph();
        p3.setAlignment(ParagraphAlignment.CENTER);
        p3.setVerticalAlignment(TextAlignment.BOTTOM);
        
        /**
         * h3
         */

        XWPFRun r3 = p3.createRun();
        r3.setBold(true);
        r3.setText("Список  № ______ Сотрудников-резидентов, в пользу которых Организация осуществляет выплаты ");
        r3.setFontFamily("Times New Roman");
        r3.setFontSize(12);
        r3.addBreak(BreakType.TEXT_WRAPPING);

        XWPFTable table = doc.createTable(5, 7);
        
        table.setWidth(30);
        System.out.println(table.getColBandSize());
        table.setColBandSize(10);
        
        table.getRow(0).getCell(0).setText("Заполняется   Организацией");
        table.getRow(0).getCell(6).setText("Заполняется Банком");
        
        table.getRow(1).getCell(0).setText("№");
        table.getRow(1).getCell(1).setText("Фамилия");
        table.getRow(1).getCell(2).setText("Имя");
        table.getRow(1).getCell(3).setText("Отчество");
        table.getRow(1).getCell(4).setText("Паспортные данные\n" +"(№, кем и когда выдан)");
        table.getRow(1).getCell(5).setText("Тип карты\n" + "(Classic, Gold)/\n" + "Вид вклада");
        table.getRow(1).getCell(6).setText("№ открытого Счета");
       

        /**
         * text
         */ 
        XWPFParagraph p4 = doc.createParagraph();
        p4.setAlignment(ParagraphAlignment.LEFT);
        p4.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r4 = p4.createRun();
        r3.setText("Руководитель             _____________  /__________________/	       	Главный бухгалтер ____________ /__________________/					");
        r3.setFontFamily("Times New Roman");
        r3.setFontSize(10);
        r3.addBreak(BreakType.TEXT_WRAPPING);

        XWPFRun r41 = p4.createRun();
        r41.setText("			       	                 (подпись, ФИО)                                                                                               (подпись, ФИО)");
        r41.setText("М.П.");
        r41.setText(" «______» ____________________ 20____г.");
        r41.setFontFamily("Times New Roman");
        r41.setFontSize(10);
        r41.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2
         */
        XWPFParagraph p5 = doc.createParagraph();
        p5.setAlignment(ParagraphAlignment.LEFT);
        p5.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r51 = p5.createRun();
        r51.setBold(true);
        r51.setText("Список предоставляется в Банк на бумажном носителе c приложением электронного файла данных согласованного формата ");
        r51.setText("__________________________________________________________________________________________________________________");
        r51.setText("Отметки Банка:");
        r51.setFontFamily("Times New Roman");
        r51.setFontSize(10);
        r51.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * text
         */
        XWPFParagraph p6 = doc.createParagraph();
        p5.setAlignment(ParagraphAlignment.LEFT);
        p5.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r61 = p6.createRun();
        r61.setText("Получено АО «БайкалИнвестБанк»: ");
        r61.setText("_______________		____________________		____________________");
        r61.setText("		    подпись			                            ФИО"); 
        r61.setText("«______» ____________________ 20____г.");
        r61.setFontFamily("Times New Roman");
        r61.setFontSize(10);
        r61.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * text
         *
        XWPFParagraph p6 = doc.createParagraph();
        p6.setAlignment(ParagraphAlignment.LEFT);
        p6.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r7 = p6.createRun();
        r7.setBold(true);
        r7.setText("Эксперт:");
        r7.setFontFamily("Times New Roman");
        r7.setFontSize(12);

        XWPFRun r71 = p6.createRun();
        r71.setText("Савчук Вячеслав Юрьевич (начальник отдела по работе с залогами)");
        r71.setFontFamily("Times New Roman");
        r71.setFontSize(12);
        r71.addBreak(BreakType.TEXT_WRAPPING);

        XWPFParagraph p61 = doc.createParagraph();
        p61.setAlignment(ParagraphAlignment.CENTER);
        p61.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r72 = p61.createRun();
        r72.setText("(Фамилия, Имя, Отчество, должность)");
        r72.setFontFamily("Times New Roman");
        r72.setFontSize(8);
        r72.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2 Наименование, индивидуально определенные признаки объекта залога:
         *
        XWPFParagraph p7 = doc.createParagraph();
        p7.setAlignment(ParagraphAlignment.BOTH);
        p7.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r73 = p7.createRun();
        r73.setBold(true);
        r73.setText("Наименование, индивидуально определенные признаки объекта залога:");
        r73.setFontFamily("Times New Roman");
        r73.setFontSize(12);
        r73.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * text
         *
        XWPFParagraph p8 = doc.createParagraph();
        p8.setAlignment(ParagraphAlignment.LEFT);
        p8.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r81 = p8.createRun();
        r81.setText(parameters.get("marka").toUpperCase() + " " + parameters.get("model").toUpperCase());
        r81.setFontFamily("Times New Roman");
        r81.setFontSize(12);
        r81.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2 Адрес местонахождения залога:
         *
         *
        XWPFParagraph p9 = doc.createParagraph();
        p9.setAlignment(ParagraphAlignment.LEFT);
        p9.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r91 = p9.createRun();
        r91.setBold(true);
        r91.setText("Адрес местонахождения залога:");
        r91.setFontFamily("Times New Roman");
        r91.setFontSize(12);
        r91.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * text
         *
        XWPFParagraph p91 = doc.createParagraph();
        p91.setAlignment(ParagraphAlignment.LEFT);
        p91.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r92 = p91.createRun();
        r92.setText("РФ," + parameters.get("mesto"));
        r92.setFontFamily("Times New Roman");
        r92.setFontSize(12);
        r92.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2 Залог относится к II категория качества
         *
         *
        XWPFParagraph p92 = doc.createParagraph();
        p92.setAlignment(ParagraphAlignment.LEFT);
        p92.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r93 = p92.createRun();
        r93.setBold(true);
        r93.setText("Залог относится  к II категория качества");
        r93.setFontFamily("Times New Roman");
        r93.setFontSize(12);
        r93.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2 Степень ликвидности залога
         *
         *
        XWPFParagraph p93 = doc.createParagraph();
        p93.setAlignment(ParagraphAlignment.LEFT);
        p93.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r931 = p93.createRun();
        r931.setBold(true);
        r931.setText("Степень ликвидности залога");
        r931.setFontFamily("Times New Roman");
        r931.setFontSize(12);
        r931.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2 Заявленные данные (физические и другие данные с учетом нормального
         * износа) залога Подтверждены
         *
         *
        XWPFParagraph p94 = doc.createParagraph();
        p94.setAlignment(ParagraphAlignment.LEFT);
        p94.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r941 = p94.createRun();
        r941.setBold(true);
        r941.setText("Заявленные данные (физические и другие данные с учетом нормального износа) залога Подтверждены");
        r941.setFontFamily("Times New Roman");
        r941.setFontSize(12);
        r941.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2 Стоимость объектов, аналогичных объекту оценки (за единицу
         * измерения, в тыс. рублей)
         *
         *
        XWPFParagraph p95 = doc.createParagraph();
        p95.setAlignment(ParagraphAlignment.LEFT);
        p95.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r951 = p95.createRun();
        r951.setBold(true);
        r951.setText("Стоимость объектов, аналогичных объекту оценки (за единицу измерения, в тыс. рублей)");
        r951.setFontFamily("Times New Roman");
        r951.setFontSize(12);
        r951.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * text parameters
         *
        XWPFParagraph p96 = doc.createParagraph();
        p96.setAlignment(ParagraphAlignment.LEFT);
        p96.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r961 = p96.createRun();

        //r961.setText("№1. " + param.get(0).getPrice() + "  №2. " + param.get(1).getPrice() + " №3. " + param.get(2).getPrice());
        r961.setFontFamily("Times New Roman");
        r961.setFontSize(12);
        r961.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2
         *
        XWPFParagraph p97 = doc.createParagraph();
        p97.setAlignment(ParagraphAlignment.LEFT);
        p97.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r971 = p97.createRun();
        r971.setBold(true);
        r971.setText("Источник информации");
        r971.setFontFamily("Times New Roman");
        r971.setFontSize(12);
        r971.addBreak(BreakType.TEXT_WRAPPING);

        // src 1
        XWPFRun r972 = p97.createRun();
        r972.setBold(true);
        r972.setText("№1");
        r972.setText("  ");
        r972.setFontFamily("Times New Roman");
        r972.setFontSize(12);

        XWPFRun r973 = p97.createRun();
        r973.setUnderline(UnderlinePatterns.WAVE);
        //r973.setText(param.get(0).getLink());
        r973.setFontFamily("Times New Roman");
        r973.setFontSize(12);
        r973.addBreak(BreakType.TEXT_WRAPPING);

        // src 2
        XWPFRun r974 = p97.createRun();
        r974.setBold(true);
        r974.setText("№2");
        r974.setText("  ");
        r974.setFontFamily("Times New Roman");
        r974.setFontSize(12);

        XWPFRun r975 = p97.createRun();
        r975.setUnderline(UnderlinePatterns.WAVE);
        //r975.setText(param.get(1).getLink());
        r975.setFontFamily("Times New Roman");
        r975.setFontSize(12);
        r975.addBreak(BreakType.TEXT_WRAPPING);

        // src 3
        XWPFRun r976 = p97.createRun();
        r976.setBold(true);
        r976.setText("№3");
        r976.setText("  ");
        r976.setFontFamily("Times New Roman");
        r976.setFontSize(12);

        XWPFRun r977 = p97.createRun();
        r977.setUnderline(UnderlinePatterns.WAVE);
        //r977.setText(param.get(2).getLink());
        r977.setFontFamily("Times New Roman");
        r977.setFontSize(12);
        r977.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2
         *
        XWPFParagraph p98 = doc.createParagraph();
        p98.setAlignment(ParagraphAlignment.LEFT);
        p98.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r981 = p98.createRun();
        r981.setBold(true);
        r981.setText("Рыночная стоимость залога составляет:" + parameters.get("ageSum") + " ₽");
        r981.setFontFamily("Times New Roman");
        r981.setFontSize(12);
        r981.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2
         *
        XWPFParagraph p99 = doc.createParagraph();
        p99.setAlignment(ParagraphAlignment.LEFT);
        p99.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r991 = p99.createRun();
        r991.setBold(true);
        r991.setText("Справедливая стоимость залога составляет:" + parameters.get("spSum") + " ₽");
        r991.setFontFamily("Times New Roman");
        r991.setFontSize(12);
        r991.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2
         *
        XWPFParagraph p100 = doc.createParagraph();
        p100.setAlignment(ParagraphAlignment.LEFT);
        p100.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r1001 = p100.createRun();
        r1001.setBold(true);
        r1001.setText("Залоговая стоимость составляет:" + parameters.get("zalSum") + " ₽");
        r1001.setFontFamily("Times New Roman");
        r1001.setFontSize(12);
        r1001.addBreak(BreakType.TEXT_WRAPPING);

        /**
         * h2
         *
        XWPFParagraph p101 = doc.createParagraph();
        p101.setAlignment(ParagraphAlignment.LEFT);
        p101.setVerticalAlignment(TextAlignment.BOTTOM);

        XWPFRun r1011 = p101.createRun();
        r1011.setBold(true);
        r1011.setText("Дата " + parameters.get("data") + "       Подпись Эксперта _______________________");
        r1011.setFontFamily("Times New Roman");
        r1011.setFontSize(12);
        r1011.addBreak(BreakType.PAGE);

        /**
         * image
         *
        try {
            XWPFParagraph p102 = doc.createParagraph();
            p102.setAlignment(ParagraphAlignment.LEFT);
            p102.setVerticalAlignment(TextAlignment.BOTTOM);

            XWPFRun r1012 = p102.createRun();
            InputStream image1 = null; //param.get(0).getImage();
            if (image1 != null) {
                r1012.addPicture(image1, XWPFDocument.PICTURE_TYPE_JPEG, "", Units.toEMU(500), Units.toEMU(400));
                r1012.addBreak(BreakType.PAGE);
            }
            InputStream image2 = null;
            if (image2 != null) {
                r1012.addPicture(image2, XWPFDocument.PICTURE_TYPE_JPEG, "", Units.toEMU(500), Units.toEMU(400));
                r1012.addBreak(BreakType.PAGE);
            }
            InputStream image3 = null;
            if (image3 != null) {
                r1012.addPicture(image3, XWPFDocument.PICTURE_TYPE_JPEG, "", Units.toEMU(500), Units.toEMU(400));
                r1012.addBreak(BreakType.PAGE);
            }

        } catch (InvalidFormatException ex) {

        } catch (IOException ex) {

        }
        
        */

        try (FileOutputStream out = new FileOutputStream(namefile);) {

            doc.write(out);
            doc.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

}
