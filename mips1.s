
        .data
      

prompt1:        .asciiz  "Enter decimal number: "
outmsg:         .asciiz  "\nThe number in hex is: "
newline:        .asciiz  "\n"
newStr: 	.space 100 
        
        .text

 

        .globl main           # Declare main label to be globally visible.
                              # Needed for correct operation with MARS
main:
	la $a0, newStr
	li $a1, 100
	li $v0, 8
	syscall 
	
	move $t0, $a0
	lb $t1, 0($t0)	# previous character
	lb $t2, 0($t0)  # final character
	li $t3, 1 	# current num
	li $t4, 1 	# final num
	
	addi $t0, $t0, 1
	
loop:
	lb $t5, 0($t0)  
	beq $t5, '\n', end  # current character
	
	beq $t1, $t5, L1
	li $t3, 1
	j L2
L1: 	
	addi $t3, $t3, 1
L2:
	bge $t3, $t4, L3
	j L4
	
L3:
	move $t2, $t5
	move $t4, $t3
	
L4: 
	move $t1, $t5


	
	addi $t0, $t0, 1
	 
j loop
end:

	li $t6, 0
loopdeux:
	beq $t6, $t4, L5
	li $v0, 11
	move $a0, $t2
	syscall
	addi $t6, $t6, 1
	j loopdeux
L5:
	  
	
