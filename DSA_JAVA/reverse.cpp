
#include<iostream>
#include<sstream>
#include<stack>
using namespace std;
int main()
{
    string s;
    string word;
    string res;
    cout<<"Enter the string";
    getline(cin,s);
    stringstream ss(s);
    stack<string> stack1;
    while(ss>> word)
    {
       stack1.push(word);      
    } 
    while(!stack1.empty())
    {
        res+=stack1.top();
        res+=" ";
        stack1.pop();
    }
    cout<<res;
    return 0;
}