#include<iostream>
using namespace std;
#include <fstream>
#include <ctime>
#include <string>
#include <windows.h>

int main() {
	setlocale(0, "");
	srand(time(0));
	fstream file, file1, file2, file3, file4, file5, file6;
	file.open("file.txt", fstream::out | fstream::in | ios_base::trunc);
	const int N = 15;

	for (int i = 0; i < N; i++)
		file << " " << rand() % 100;

	file.seekp(0);
	file1.open("file1.txt", fstream::out | fstream::in | ios_base::trunc);
	file2.open("file2.txt", fstream::out | fstream::in | ios_base::trunc);
	file3.open("file3.txt", fstream::out | fstream::in | ios_base::trunc);
	file4.open("file4.txt", fstream::out | fstream::in | ios_base::trunc);
	file5.open("file5.txt", fstream::out | fstream::in | ios_base::trunc);
	file6.open("file6.txt", fstream::out | fstream::in | ios_base::trunc);
	int buf;
	while (true) {
		if (file.eof())
			break;
		file >> buf;
		file1 << " " << buf;
		if (file.eof())
			break;
		file >> buf;
		file2 << " " << buf;
		if (file.eof())
			break;
		file >> buf;
		file3 << " " << buf;
	}

	file1.seekp(0);
	file2.seekp(0);
	file3.seekp(0);

	for (int n = 1;; n *= 3) {
		bool emptyfile5 = true;
		int numfile = 4;
		char ch;
		int minx;
		while (!(file1.eof() && file2.eof() && file3.eof())) {
			int x1, x2, x3;
			file1 >> x1;
			file2 >> x2;
			file3 >> x3;
			int count1 = 0, count2 = 0, count3 = 0;
			for (int i = 0; i < n * 3; i++){
				if (x1 > x2 && x1 > x3 && x1 != NULL){
					minx = 1;
				}
				else{
					if (x2 > x3 && x2 != NULL){
						minx = 2;
					}
					else{
						if (x3 != NULL)	{
							minx = 3;
						}
						else{
							minx = 0;
						}
					}
				}
				switch (numfile){
				case 4:
					switch (minx){
					case 1:	{
						file4 << " " << x1;
						count1++;
						if (count1 >= n || file1.eof())
							x1 = NULL;
						else{
							file1 >> x1;
						}
					}
					break;
					case 2:{
						file4 << " " << x2;
						count2++;
						if (count2 >= n || file2.eof())
							x2 = NULL;
						else{
							file2 >> x2;
						}
					}
					break;
					case 3:{
						file4 << " " << x3;
						count3++;
						if (count3 >= n || file3.eof())
							x3 = NULL;
						else{
							file3 >> x3;
						}
					}
					break;
					}
					break;
				case 5:
					switch (minx){
					case 1:
						file5 << " " << x1;
						emptyfile5 = false;
						count1++;
						if (count1 >= n || file1.eof())
							x1 = NULL;
						else{
							file1 >> x1;
						}
						break;
					case 2:
						file5 << " " << x2;
						emptyfile5 = false;
						count2++;
						if (count2 >= n || file2.eof())
							x2 = NULL;
						else{
							file2 >> x2;
						}
						break;
					case 3:
						file5 << " " << x3;
						emptyfile5 = false;
						count3++;
						if (count3 >= n || file3.eof())
							x3 = NULL;
						else{
							file3 >> x3;
						}
						break;
					}
					break;
				case 6:
					switch (minx){
					case 1:
						file6 << " " << x1;
						count1++;
						if (count1 >= n || file1.eof())
							x1 = NULL;
						else{
							file1 >> x1;
						}
						break;
					case 2:
						file6 << " " << x2;
						count2++;
						if (count2 >= n || file2.eof())
							x2 = NULL;
						else{
							file2 >> x2;
						}
						break;
					case 3:
						file6 << " " << x3;
						count3++;
						if (count3 >= n || file3.eof())
							x3 = NULL;
						else{
							file3 >> x3;
						}
						break;
					}
					break;
				}
			}
			if (file1.eof() && file2.eof() && file3.eof())
				break;
			numfile++;
			if (numfile == 7)
				numfile = 4;
		}
		file1.close();
		file2.close();
		file3.close();
		file1.open("file1.txt", fstream::out | fstream::in | ios_base::trunc);
		file2.open("file2.txt", fstream::out | fstream::in | ios_base::trunc);
		file3.open("file3.txt", fstream::out | fstream::in | ios_base::trunc);
		file4.seekp(0);
		file5.seekp(0);
		file6.seekp(0);
		if (emptyfile5)
			break;
		n *= 3;
		numfile = 1;
		while (!(file4.eof() && file5.eof() && file6.eof())){
			int x1, x2, x3;
			file4 >> x1;
			file5 >> x2;
			file6 >> x3;
			int count1 = 0, count2 = 0, count3 = 0;
			for (int i = 0; i < n * 3; i++)	{
				if (x1 > x2 && x1 > x3 && x1 != NULL){
					minx = 1;
				}
				else{
					if (x2 > x3 && x2 != NULL){
						minx = 2;
					}
					else{
						if (x3 != NULL)	{
							minx = 3;
						}
						else{
							minx = 0;
						}
					}
				}
				switch (numfile){
				case 1:
					switch (minx){
					case 1:{
						file1 << " " << x1;
						count1++;
						if (count1 >= n || file4.eof())
							x1 = NULL;
						else{
							file4 >> x1;
						}
						break;
					}
					break;
					case 2:	{
						file1 << " " << x2;
						count2++;
						if (count2 >= n || file5.eof())
							x2 = NULL;
						else{
							file5 >> x2;
						}
						break;
					}
					break;
					case 3:	{
						file1 << " " << x3;
						count3++;
						if (count3 >= n || file6.eof())
							x3 = NULL;
						else{
							file6 >> x3;
						}
						break;
					}
					break;
					}
					break;
				case 2:
					switch (minx){
					case 1:
						file2 << " " << x1;
						count1++;
						if (count1 >= n || file4.eof())
							x1 = NULL;
						else{							
							file4 >> x1;
						}
						break;
					case 2:
						file2 << " " << x2;
						count2++;
						if (count2 >= n || file5.eof())
							x2 = NULL;
						else{
							file5 >> x2;
						}
						break;
					case 3:
						file2 << " " << x3;
						count3++;
						if (count3 >= n || file6.eof())
							x3 = NULL;
						else{
							file6 >> x3;
						}
						break;
					}
					break;
				case 3:
					switch (minx){
					case 1:
						file3 << " " << x1;
						count1++;
						if (count1 >= n || file4.eof())
							x1 = NULL;
						else{
							file4 >> x1;
						}
						break;
					case 2:
						file3 << " " << x2;
						count2++;
						if (count2 >= n || file5.eof())
							x2 = NULL;
						else{
							file5 >> x2;
						}
						break;
					case 3:
						file3 << " " << x3;
						count3++;
						if (count3 >= n || file6.eof())
							x3 = NULL;
						else{
							file6 >> x3;
						}
						break;
					}
					break;
				}
			}
			if (file1.eof() && file2.eof() && file3.eof())
				break;
			numfile++;
			if (numfile == 4)
				numfile = 1;
		}
		file1.seekp(0);
		file2.seekp(0);
		file3.seekp(0);
		file4.close();
		file5.close();
		file6.close();
		file4.open("file4.txt", fstream::out | fstream::in | ios_base::trunc);
		file5.open("file5.txt", fstream::out | fstream::in | ios_base::trunc);
		file6.open("file6.txt", fstream::out | fstream::in | ios_base::trunc);
	}
	system("pause");
}
