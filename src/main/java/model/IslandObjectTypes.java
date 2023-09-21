package model;

public enum IslandObjectTypes {
    Wolf("Вовк"),
    Python("Пітон"),
    Fox("Лисиця"),
    Bear("Ведмідь"),
    Eagle("Орел"),
    Horse("Кінь"),
    Deer("Олень"),
    Rabbit("Кролик"),
    Mouse("Миша"),
    Goat("Коза"),
    Sheep("Вівця"),
    Boar("Кабан"),
    Buffalo("Буйвол"),
    Duck("Качка"),
    Caterpillar("Гусінь"),
    Bush("Кущ"),
    Tree("Дкрево"),
    Grass("Трава");

    IslandObjectTypes(String name){
        this.name = name;
    }
    private String name;
    public String getName(){return name;}
}
