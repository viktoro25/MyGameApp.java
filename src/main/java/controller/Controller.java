package controller;

import java.util.List;
import java.util.TreeMap;

public interface Controller {

    /** Генерує хаотично.
     * @return Повертає список тварин
     */
    List<? extends Object> automaticGeneration() throws InstantiationException, IllegalAccessException;

    /** Генерує об'єкти з пареметрами кількості
     * @return Повертає список.
     * Коли доавляэмо новий вид обєкта необхідно дабавити його в список параметрів.
     */
    List<? extends Object> parametersGenerationAll(TreeMap <String, Integer> treeMap) throws InstantiationException, IllegalAccessException;
}
