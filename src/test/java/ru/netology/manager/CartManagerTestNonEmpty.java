package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;

import static org.junit.jupiter.api.Assertions.*;

public class CartManagerTestNonEmpty {
  @Test
  public void shouldRemoveIfExists() {   // удалить существующий элемент
    CartManager manager = new CartManager();
    int idToRemove = 1;                  // определяем id эл-та, который планируем удалить
                                          //создаем объекты(покупки) с разными значениями полей
    PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);


    // добавляем их в объект manager путем вызова метода add
    manager.add(first);
    manager.add(second);
    manager.add(third);

    manager.removeById(idToRemove); //вызываем метод для удаления покупок и вставляем в него тот id, который будем удалять

    PurchaseItem[] actual = manager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{third, second};

//    assertEquals(expected, actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    CartManager manager = new CartManager();
    int idToRemove = 4;
    PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
    manager.add(first);
    manager.add(second);
    manager.add(third);

    manager.removeById(idToRemove);

    PurchaseItem[] actual = manager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{third, second, first};

    assertArrayEquals(expected, actual);
  }
}