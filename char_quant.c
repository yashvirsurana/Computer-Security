// ==========================================================================
// Character quantification
// ==========================================================================
// Prints the last substring with to the longest run of a single character

// Inf2C-CS Coursework 1. Task A 
// PROVIDED file, to be used as model for writing MIPS code.

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
// MAIN function
//---------------------------------------------------------------------------

int main (void)
{
  char input_string[100];
  int i=0,k;
  char current_char, previous_char, final_char;
    
  int current_num_chars, final_num_chars;
   
  /////////////////////////////////////////////
  
  print_string("input: ");
  
  do {           
    current_char=read_char();
    input_string[i]=current_char;
    i++;
  } while (current_char != '\n');
  
  /////////////////////////////////////////////  
  
  previous_char = input_string[0];
  final_char=input_string[0];
  
  current_num_chars=1;
  final_num_chars=1; 
  
  for(k=1; k<i-1; k++)  {		// Note that the value of k=i-1 is '\n'
    current_char=input_string[k];  
    
    if(current_char == previous_char) {            
      current_num_chars++;             
    }
    else {
      current_num_chars=1;
    }
    
    if(current_num_chars >= final_num_chars) {      
	final_char=current_char;
	final_num_chars=current_num_chars;	
    }
    
    previous_char=current_char;
  }
  
  //print_char('\n');
  
  /////////////////////////////////////////////      
  
  print_string("output: ");    
    
  for(k=0; k<final_num_chars; k++)  {    
    print_char(final_char);  
  }
  
   print_char('\n'); 
   
  /////////////////////////////////////////////
   
  return 0;
}

//---------------------------------------------------------------------------
// End of file
//---------------------------------------------------------------------------

