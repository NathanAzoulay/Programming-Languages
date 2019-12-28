/**
 * Program #2
 * This program performs matrix multiplication by using pointers.
 * CS-320-2
 * September 30, 2019
 * @author Nathan Azoulay cssc0445
 */

#include "p2.h"

int main(int argc, char **argv){
        int *A, *B,*C;
        int m,n,p;
        FILE *ptr;
        ptr = fopen(argv[1],"r");
        if(ptr == NULL){
                printf("File doesn't exist\n");
                exit(1);
        }/* Checks if file exists */

        read_matrices(&A,&B,&C, &m, &n, &p, argv[1]);
        mult_matrices(A,B,C,m,n,p);
        printf("Program #2, cssc0445, Nathan Azoulay\n");
        printf("Matrix A contents:\n");
        print_matrix(A,m,n);
        printf("Matrix B contents:\n");
        print_matrix(B,n,p);
        printf("Matrix A * B is:\n");
        print_matrix(C,m,p);

        free(A);
        free(B);
        free(C);
        return 0;
}

void read_matrices(int **A, int **B, int **C, int *m, int *n, int *p, char *fileName){
        FILE *file=fopen(fileName, "r");
        fscanf(file,"%d", m);
        fscanf(file,"%d", n);
        fscanf(file,"%d", p);
        int i,j;

        /*Allocate memory for A,B,C and fill them from input file */
        *A = (int *) malloc(*m**n * sizeof(int));
        if(*A==NULL){
                return;
        }
        for(i=0; i<*m; i++){
                for(j=0; j<*n; j++){
                        fscanf(file,"%d",(*A+i**n+j));
                }
        }

        *B = (int *) malloc(*n * *p * sizeof(int));
        if(*B==NULL){
                return;
        }
        for(i=0; i<*n; i++){
                for(j=0; j<*p; j++){
                        fscanf(file,"%d",(*B+i**p+j));
                }
        }

        *C = (int *)malloc(*m* *p *sizeof(int));
        if(*C==NULL){
                return;
        }
        return;
}

/* This method prints the matrix */
void print_matrix(int *mat, int row, int col){
        int i,j;
        for(i=0; i<row; i++){
                for(j=0; j<col; j++){
                        printf("%d ",*(mat+i*col+j));
                }
                printf("\n");
        }
        printf("\n");
        return;
}

/* Method multiplies matrices by pointer arithmetic */
void mult_matrices(int *A, int *B, int *C, int m, int n, int p){
        int i,j,q;

        for(i=0; i<m; i++){
                for(j=0; j<p; j++){
                        *((C+i*p)+j)= 0;       
                        for(q=0;q<n;q++){
                        *((C+i*p)+j) += *((A+i*n)+q) * *((B+q*p)+j);
                        }
                }
        }

        return;
}