#include <iostream>
#include <string>
#include <fstream>
#include <vector>
using namespace std;

struct bank_account
{
    int num;
    string name;
    string surname;
    string second_name;
    string address;
};
vector<bank_account>bk;

void print_data(bank_account a)
{
    cout << "Number : " << a.num << "\nName : " << a.name << "\nSurname : " << a.surname << "\nSecond Name : " << a.second_name << "\nAddress : " << a.address << endl;
    cout << "________________\n";
}

void write_data_to_file()
{
    ofstream ou("bank.txt");

    if (ou.is_open())
    {
        for (int i = 0; i < bk.size(); i++)
        {
            bank_account temp = bk[i];
            ou << temp.num << " " << temp.name << " "<< temp.surname << " "<< temp.second_name << " "<< temp.address<< "\n";
        }
    }
    ou.close();
}

void write_data_to_binary()
{
    bank_account temp;
    ofstream out("binary.txt", ostream::binary);
    for (int i = 0; i <bk.size(); ++i)
        out.write((char*)&bk.at(i), sizeof(bank_account));

    out.close();
}

void read_data_from_binary_file()
{
    ifstream fin("binary.txt", istream::binary);
    bank_account temp;
    for (int i = 0; i < bk.size(); i++)
        fin.read((char*)&bk.at(i), sizeof(bank_account));

    fin.close();
}

void print_all_data()
{
    for (int i = 0; i < bk.size(); i++)
        print_data(bk[i]);
}

void find()
{
    int a;
    cout << "Input number of account, which you want to find: ";
    cin >> a;
    cout << endl;
    for (int i = 0; i < bk.size(); i++)
    {
        if (bk[i].num == a)
            print_data(bk[i]);
    }
}

void change()
{
    int a;
    string b;
    cout << "Input number of account, which you want to change : ";
    cin >> a;
    cout << endl;

    cout << "Input new name : ";
    cin >> b;
    cout << endl;

    read_data_from_binary_file();
    for (int i = 0; i < bk.size(); i++)
    {
        if (bk[i].num == a)
            bk[i].name = b;
    }
    write_data_to_binary();
}

void del()
{
    int a;
    cout << "Input number of account, which you want to delete : ";
    cin >> a;
    cout << endl;
    read_data_from_binary_file();

    for (int i = 0; i < bk.size(); i++){
        if (bk[i].num == a)
            bk.erase(bk.begin() + i);
    }
    write_data_to_binary();
}

int main()
{
    bank_account first{1234567, "Ivan", "Ivanov", "Ivanov", "Perm"};
    bk.push_back(first);

    bank_account second{7654321, "Alex", "Alexandrov", "Sergeevich", "Moscow"};
    bk.push_back(second);

    write_data_to_file();
    print_all_data();
    cout << "____________________________________\n";

    write_data_to_binary();
    read_data_from_binary_file();
    find();
    cout << "____________________________________\n";

    change();
    print_all_data();
    cout << "____________________________________\n";

    del();
    print_all_data();
}
