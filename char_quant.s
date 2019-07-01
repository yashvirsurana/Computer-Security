
        .data
      

prompt1:        .asciiz  "input: "
outmsg:         .asciiz  "output: "
newline:        .asciiz  "\n"
newStr: 	.space 100 
        
        .text

 

        .globl main             # Declare main label to be globally visible.
                                # Needed for correct operation with MARS
main:
	la    $a0, prompt1 	# make $a0 point to where the message is
    	li    $v0, 4   		# $v0 <- 4
    	syscall        		# Call the OS to print the message

	la $a0, newStr		# load address of newStr into $a0
	li $a1, 100		
	li $v0, 8
	syscall 
	
	move $t0, $a0		# move the entered string to $t0
	
        la    $a0, outmsg 	# make $a0 point to where the message is
        li    $v0, 4  		# $v0 <- 4
        syscall        		# Call the OS to print the message

	
	
	lb $t1, 0($t0)		# previous character
	lb $t2, 0($t0)  	# final character
	li $t3, 1 		# current num
	li $t4, 1 		# final num
	
	
	addi $t0, $t0, 1	
	
loop:
	lb $t5, 0($t0)  	# current character
	beq $t5, '\n', end 	# conditional which checks if the string has come to an end, if it has end the loop
	
	beq $t1, $t5, L1	#conditional which checks if previous character is equal to current character, go to L1 if yes
	li $t3, 1		#current num is 1
	j L2			#else jump to l2
L1: 	
	addi $t3, $t3, 1	#add 1 to current num if the character are matched thus updating the counter
L2:
	bge $t3, $t4, L3	#if current num is greater than or equal to final num then go to l3 else branch to l4
	j L4
	
L3:
	move $t2, $t5		#register for final character is replaced by the current character
	move $t4, $t3		#counter final num is updated and replaced by the current num count
	
L4: 
	move $t1, $t5		#current character is moved to previous character


	
	addi $t0, $t0, 1
	 
j loop
end:

	li $t6, 0		# 0 is loaded to $t6 as a counter
loopdeux:
	beq $t6, $t4, L5	
	li $v0, 11		
	move $a0, $t2
	syscall
	addi $t6, $t6, 1
	j loopdeux
L5:
	  
	
