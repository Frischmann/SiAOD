from RedBlackTree import RedBlackTree
rbt = RedBlackTree()


def menu():
    x = int(input("\nВыберите действие с деревом:\n1 - Добавить элемент\n2 - Удалить элемент\n3 - Печать дерева\nВвод: "))
    if (x == 1):
        rbt.insert(int(input("Введите число для добавления его на дерево: ")))
        print("Число успешно добавлено на дерево!\n")
        menu()
    elif (x == 2):
        rbt.delete_node(
            int(input("Введите число которое вы хотите удалить: ")))
        print("Число успешно удалено из дерева!\n")
        menu()
    elif (x == 3):
        print("\nR - right, L - left\n")
        rbt.pretty_print()
        menu()
    else:
        print("Действие не найдено! Повторите ввод.")
        menu()


def main():
    numbers = list(
        map(int, input("Введите числа для добавления их на дерево: ").split()))

    for i in numbers:
        rbt.insert(i)

    menu()


if __name__ == "__main__":
    main()
