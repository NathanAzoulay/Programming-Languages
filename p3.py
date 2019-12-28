# Program 3
# Matrix multiplication using the Python language
# CS370-2
# October 14, 2019
# @author Nathan Azoulay

import sys

# Our main method where A and B are initially created.
# Calls read_matrices to fill them and multiply_matrices to get result
# We use the print_matrix() function to print each individual matrix
def main():
	print("Program #3, cssc0445, Nathan Azoulay")
	A = []
	B = []
	C = read_matrices(A,B)
	print("Matrix A contents: ")
	print_matrix(A)
	print("Matrix B contents: ")
	print_matrix(B)
	multiply_matrices(A,B,C)
	print("Matrix A*B contents: ")
	print_matrix(C)
	
# This function read m,n, and p from the datafile and are filled.
# Matrix C is allocated size m x p
# Parameters are both lists A and B
def read_matrices(A,B):
	fileName = sys.argv[1]
	f = open(fileName,"r+")
	m = [int(x) for x in next(f).split()][0]
	n = [int(x) for x in next(f).split()][0]
	p = [int(x) for x in next(f).split()][0]
	for i in range(0, m):
		A.append(list(map(int,f.readline().split()[:n])))
	for i in range(0,n):
		B.append(list(map(int,f.readline().split()[:p])))
	C = [[0 for i in range(p)] for j in range(m)]
	f.close()
	return C
	
# This function prints a matrix taking a list as its parameter
def print_matrix(matrix):
	for row in matrix:
		for element in row:
			print(element,end=' ')
		print()
	print()
	
# The two matrices A and B are multiplied, and matrix C contains the result
# Parameters are A,B,C
def multiply_matrices(A,B,C):
	for i in range(len(A)):
		for j in range(len(B[0])):
		C[i][j] = 0
		for k in range(len(B)):
			C[i][j] += A[i][k] * B[k][j]

# Begin program and print error if file not found
if __name__ == "__main__":
	try:
		main()
	except IOError:
		print('File not found')
		