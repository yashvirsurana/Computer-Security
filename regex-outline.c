// ==========================================================================
// Regular expressions matching 
// ==========================================================================
// Print the matching substring between an input string and and input search pattern
//
// Inf2C-CS Coursework 1. Task B 
// OUTLINE code, to be completed as part of coursework.

// Boris Grot, Jose Cano
//  7 Oct 2014

//---------------------------------------------------------------------------
// C definitions for SPIM system calls
//---------------------------------------------------------------------------
#include <stdio.h>

int read_char() { return getchar(); }
void read_string(char* s, int size) { fgets(s, size, stdin); }

void print_char(int c)     { putchar(c); }   
void print_string(char* s) { printf("%s", s); }

//---------------------------------------------------------------------------
// Global variables
//---------------------------------------------------------------------------

// TO BE COMPLETED

//---------------------------------------------------------------------------
// Functions
//---------------------------------------------------------------------------

// TO BE COMPLETED

//---------------------------------------------------------------------------
// MAIN function
//---------------------------------------------------------------------------


int main (int argc, char** argv) {
  
  char input_string[100], search_pattern[50], matching_substring[100];  
  int i=0;
  char current_char;
  
  /////////////////////////////////////////////    
        
  print_string("input: ");
  
  do {           
    current_char=read_char();
    input_string[i]=current_char;
    i++;
  } while (current_char != '\n');
  
  /////////////////////////////////////////////
  
  while(1) {
    
    i=0;       
        
    print_char('\n');
    
    print_string("search pattern: ");     
    
    do {           
      current_char=read_char();
      search_pattern[i]=current_char;
      i++;
    } while (current_char != '\n');
          
    /////////////////////////////////////////////     
    
    // TO BE COMPLETED

    print_string("output: ");          
      
    //
    
    /////////////////////////////////////////////
    matching_substring[0] == '\0';
    int hash = 0;
    int i = 0;
    int isMatch = 0;
    while(input_string[i] != '\n') {
      int j = 0;
      int k = 0;
      int temp = i; 
      while(search_pattern[j] != '\n') {

	if (search_pattern[j] == input_string[temp]) {
	  matching_substring[k] = input_string[temp];
	  k++;
	  temp++;
	  j++;
	  matching_substring[k] = '\0';
	}
	else if (search_pattern[j] == '.') {
	  matching_substring[k] = input_string[temp];
	  k++;
	  temp++;
	  j++;
	  matching_substring[k] = '\0';
        }
	else if (search_pattern[j] == '*') {
	   while (input_string[temp] == search_pattern[j-1]) {
	       matching_substring[k] = input_string[temp];
	       temp++;
	       k++;
	       matching_substring[k] = '\0';
	   }
	   j++;
	}
	else if (search_pattern[j] == '\\' && search_pattern[j+1] == '.' && input_string[i] == '.') {
	  matching_substring[k] = '.';
	  temp++;
	  k++;
	  j = j + 2;
	  matching_substring[k] = '\0';

	}
	else {
	  k = 0;
	  break;
	}
      

      }
      if (k > 0) {
	if (hash == 1) {
	  print_char('#');
	}
	hash = 1;
	print_string(matching_substring);
	i = temp;
	isMatch = 1;
      }
      else {
	i++;
      }
       
    }
    
    if (isMatch == 0) {
      print_string("No matches found!");
	}
    
    print_char('\n'); 

  return 0;
}

}



//---------------------------------------------------------------------------
// End of file
//---------------------------------------------------------------------------
