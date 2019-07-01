
        .data
     
prompt1:        .asciiz  "input: "
prompt2:        .asciiz  "search pattern: "
outmsg:	        .asciiz  "output: "
newline:        .asciiz  "\n"
newStr: 	.space 100 
input:		.space 100
pattern:	.space 100
result:		.space 100        
        .text

        .globl main        
        		     # Declare main label to be globally visible.
                                # Needed for correct operation with MARS
main:
	
	la     	$a0, prompt1 	# make $a0 point to where the message is
    	li    	$v0, 4   	# $v0 <- 4
    	syscall 
    	
    	la	$a0, input 	#load address of newStr to $a0
    	li	$a1, 100	#string size 100 chars		
	li	$v0, 8		#dont know what that means
	syscall 
	
	move 	$s0, $a0	#move entered string to $s0
	
	li 	$v0, 4
	la 	$a0, prompt2	#prompt for search pattern
	syscall
	
	la 	$a0, pattern 	#load address of newStr to $a0
	li 	$a1, 100 	#string size 100 chars
	li 	$v0, 8		
	syscall
	
	move 	$s1, $a0	#move entered search pattern to $s1
	li	$s2, '\0'	#initialise matching-substring[k]
	la	$s4, result	#load address of result in $s4
	sb 	$s2, 0($s4)	#store byte
	
	#------------------------------------------------------------------------------------------ #
	
	li	$t0, 0 		#int hash=0;
	li 	$t1, 0		#int i=0;
	li 	$t2, 0		#int isMatch=0;
	
firstWhileLoop:
	
	lb	$t3, 0($s0) 	#input_string[i] is $t3
	beq	$t3, '\n', firstWhileLoopEnd
	la 	$s1, pattern #j		
	la 	$s4, result #k 
	move 	$t5, $s0 #temo
	# S0 is i
	# S1 is j
	# S4 is k
	# T5 is temp
secondWhileLoop:
	
	lb 	$t7, 0($s1) 	#load search pattern[j]
	beq	$t7, '\n', secondWhileLoopEnd
	lb 	$t6, 0($t5) # input string of temp
	bne	$t7, $t3, endCond1	#first conditional starts
	sb	$t6, 0($s4)	#store that letter in s2
	addi $s4, $s4, 1
	addi $s1, $s1, 1
	addi $t5, $t5, 1
	li $t9, '\0'
	sb $t9, 0($s4)
		
endCond1:
	#bne	$t7, '.', endCond2 # second conditional starts
	#sb	$t7, 0($s2)	
	#addi	$t5, $t5, 1	#increment k by 1
	#addi	$t4, $t4, 1	#increment j by 1
	#addi	$t6, $t6, 1	#increment temp by 1
	la 	$s4, result
	
	
j secondWhileLoop
secondWhileLoopEnd:

la $t9, result
beq $s4, $t9, elseif
beqz $t0, nohash

li $v0, 11
li $a0, '#'
syscall

nohash:

li $t0, 1

li $v0, 4
la $a0, result
syscall

move $s0, $t5

elseif:
	addi $s0, $s0, 1

j firstWhileLoop
firstWhileLoopEnd:
	
	
	
