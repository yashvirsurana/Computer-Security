/**
 * File:   MH_Parser.java
 * Date:   October 2014
 *
 * Java template file for parser component of Informatics 2A Assignment 2 (2014).
 * Students should add a method body for the LL(1) parse table for Micro-Haskell.
 */

import java.io.*;

class MH_Parser extends GenParser implements Parser {

    public String startSymbol() {
        return "#Prog";
    }

    // Right hand sides of all productions in grammar:

    String[] epsilon              = new String[] { };
    String[] Decl_Prog            = new String[] {"#Decl", "#Prog"};
    String[] TypeDecl_TermDecl    = new String[] {"#TypeDecl", "#TermDecl"};
    String[] TypeDecl_rule        = new String[] {"VAR", "::", "#Type", ";"};
    String[] Type1_TypeOps        = new String[] {"#Type1", "#TypeOps"};
    String[] arrow_Type           = new String[] {"->", "#Type"};
    String[] Integer              = new String[] {"Integer"};
    String[] Bool                 = new String[] {"Bool"};
    String[] lbr_Type_rbr         = new String[] {"(", "#Type", ")"};

    String[] TermDecl_rule        = new String[] {"VAR", "#Args", "=", 
                                                  "#Exp", ";"};
    String[] VAR_Args             = new String[] {"VAR", "#Args"};
    String[] Exp0                 = new String[] {"#Exp0"};
    String[] if_then_else         = new String[] {"if", "#Exp", "then", 
                                                  "#Exp", "else", "#Exp"};
    String[] Exp1_Op0             = new String[] {"#Exp1", "#Op0"};
    String[] eq_Exp1              = new String[] {"==", "#Exp1"};
    String[] lt_Exp1              = new String[] {"<", "#Exp1"};
    String[] Exp2_Ops1            = new String[] {"#Exp2", "#Ops1"};
    String[] plus_Exp2_Ops1       = new String[] {"+", "#Exp2", "#Ops1"};
    String[] minus_Exp2           = new String[] {"-", "#Exp2"};
    String[] Exp3_Ops2            = new String[] {"#Exp3", "#Ops2"};
    String[] VAR                  = new String[] {"VAR"};
    String[] NUM                  = new String[] {"NUM"};
    String[] BOOLEAN              = new String[] {"BOOLEAN"};
    String[] lbr_Exp_rbr          = new String[] {"(", "#Exp", ")"};

    public String[] tableEntry (String tokenClass, String nonterm) {

        // ADD YOUR CODE HERE
    	if (nonterm == "#Prog") {
    		if (tokenClass == null) {
    			return epsilon;
    		} else  if (tokenClass == "VAR") {
    			return Decl_Prog;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Decl") {
    		if (tokenClass == "VAR") {
    			return TypeDecl_TermDecl;
    			}
    		else return null;
    	}
    	
    	if (nonterm == "#TypeDecl") {
    		if (tokenClass == "VAR") {
    			return TypeDecl_rule;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Type") {
    		if (tokenClass == "Integer") {
    			return Type1_TypeOps;
    		}
    		else if (tokenClass == "Bool") {
    			return Type1_TypeOps;
    		}
    		else if (tokenClass == "(") {
    			return Type1_TypeOps;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#TypeOps") {
    		if (tokenClass == ";") {
    			return epsilon;
    		}
    		else if (tokenClass == "->") {
    			return arrow_Type;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Type1") {
    		if (tokenClass == "Integer") {
    			return Integer;
    		}
    		else if (tokenClass == "Bool") {
    			return Bool;
    		}
    		else if (tokenClass == "(") {
    			return lbr_Type_rbr;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#TermDecl") {
    		if (tokenClass == "VAR") {
    			return TermDecl_rule;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Args") {
    		if (tokenClass == "VAR") {
    			return VAR_Args;
    		}
    		else if (tokenClass == "=") {
    			return epsilon;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Exp") {
    		if (tokenClass == "VAR") {
    			return Exp0; 
    		}
    		else if (tokenClass == "NUM") {
    			return Exp0;
    		}
    		else if (tokenClass == "BOOLEAN") {
    			return Exp0;
    		}
    		else if (tokenClass == "if") {
    			return if_then_else;
    		}
    		else if (tokenClass == "(") {
    			return Exp0;
    		}
    		else if (tokenClass == "-") {
    			return Exp0;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Exp0") {
    		if (tokenClass == "VAR") {
    			return Exp1_Op0;
    		}
    		else if (tokenClass == "NUM") {
    			return Exp1_Op0;
    		}
    		else if (tokenClass == "BOOLEAN") {
    			return Exp1_Op0;
    		}
    		else if (tokenClass == "(") {
    			return Exp1_Op0;
    		}
    		else if (tokenClass == "-") {
    			return Exp1_Op0;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Op0") {
    		if (tokenClass == "then") {
    			return epsilon;
    		}
    		else if (tokenClass == "else") {
    			return epsilon;
    		}
    		else if (tokenClass == ")") {
    			return epsilon;
    		}
    		else if (tokenClass == ";") {
    			return epsilon;
    		}
    		else if (tokenClass == "==") {
    			return eq_Exp1;
    		}
    		else if (tokenClass == "<") {
    			return lt_Exp1;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Exp1") {
    		if (tokenClass == "VAR") {
    			return Exp2_Ops1;
    		}
    		else if (tokenClass == "NUM") {
    			return Exp2_Ops1;
    		}
    		else if (tokenClass == "BOOLEAN") {
    			return Exp2_Ops1;
    		}
    		else if (tokenClass == "(") {
    			return Exp2_Ops1;
    		}
    		else if (tokenClass == "-") {
    			return Exp2_Ops1;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Ops1") {
    		if (tokenClass == "then") {
    			return epsilon;
    		}
    		else if (tokenClass == "else") {
    			return epsilon;
    		}
    		else if (tokenClass == ")") {
    			return epsilon;
    		}
    		else if (tokenClass == ";") {
    			return epsilon;
    		}
    		else if (tokenClass == "==") {
    			return epsilon;
    		}
    		else if (tokenClass == "<") {
    			return epsilon;
    		}
    		else if (tokenClass == "+") {
    			return plus_Exp2_Ops1;
    		}
    		else return null;
     	}
    	
    	if (nonterm == "#Exp2") {
    		if (tokenClass == "VAR") {
    			return Exp3_Ops2;
    		}
    		else if (tokenClass == "NUM") {
    			return Exp3_Ops2;
    		}
    		else if (tokenClass == "BOOLEAN") {
    			return Exp3_Ops2;
    		}
    		else if (tokenClass == "(") {
    			return Exp3_Ops2;
    		}
    		else if (tokenClass == "-") {
    			return minus_Exp2;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Ops2") {
    		if (tokenClass == "VAR") {
    			return Exp3_Ops2; 
    		}
    		else if (tokenClass == "NUM") {
    			return Exp3_Ops2;
    		}
    		else if (tokenClass == "BOOLEAN") {
    			return Exp3_Ops2;
    		}
    		else if (tokenClass == "then") {
    			return epsilon;
    		}
    		else if (tokenClass == "else") {
    			return epsilon;
    		}
    		else if (tokenClass == "(") {
    			return Exp3_Ops2;
    		}
    		else if (tokenClass == ")") {
    			return epsilon;
    		}
    		else if (tokenClass == ";") {
    			return epsilon;
    		}
    		else if (tokenClass == "==") {
    			return epsilon;
    		}
    		else if (tokenClass == "<") {
    			return epsilon;
    		}
    		else if (tokenClass == "+") {
    			return epsilon;
    		}
    		else return null;
    	}
    	
    	if (nonterm == "#Exp3") {
    		if (tokenClass == "VAR") {
    			return VAR;
    		}
    		else if (tokenClass == "NUM") {
    			return NUM;
    		}
    		else if (tokenClass == "BOOLEAN") {
    			return BOOLEAN;
    		}
    		else if (tokenClass == "(") {
    			return lbr_Exp_rbr;
    		}
    		else return null;
     	}
    	
    	else return null;
    
    }

}


/**
 * For testing
 */
class MH_ParserDemo {

    static Parser MH_Parser = new MH_Parser();

    public static void main (String[] args) throws Exception {
        Reader reader = new BufferedReader(new FileReader (args[0]));
    
        LEX_TOKEN_STREAM MH_Lexer = new CheckedSymbolLexer(new MH_Lexer(reader));

        TREE theTree = MH_Parser.parse(MH_Lexer);
    }
}
