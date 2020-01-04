; Program #6
; Odds, evenreverse, penultimate, and palindrome function in Scheme/Racket
; CS320-2
; December 9, 2019
; @author Nathan Azoulay cssc0445

#lang racket


; Edit this file to add your documentation and function definitions.
; Leave the rest of this file unchanged.
; To run this file, you would start scheme at edoras command line prompt:
; scheme --load p6.scm, where the file is in the current directory
; and then in scheme type the load command (from the '%' prompt):
;(load "p6.scm")
;
; Defined LISTS for use with testing your functions.

(define list0 (list 'j 'k 'l 'm 'n 'o 'j) )
(define list1 (list 'a 'b 'c 'd 'e 'f 'g) )
(define list2 (list 's 't 'u 'v 'w 'x 'y 'z) )
(define list3 (list 'j 'k 'l 'm 'l 'k 'j) )
(define list4 (list 'n 'o 'p 'q 'q 'p 'o 'n) )
(define list5 '((a b) c (d e d) c (a b)) )
(define list6 '((h i) (j k) l (m n)) ) 
(define list7 '(f (a b) c (d e d) (b a) f) )
;
; Here is a typical function definition from Sebesta Ch. 15

; The above five lines are the sort of definition you would need to add to
; this file if asked to define an ADDER function.
; Uncomment and complete the following four definitions. At least have ODDS
; so the program can be tested.

(define (odds lis)
  (if (not (list? lis))    ; Checks if parameter is a list
      "USAGE: (odds (list))"
  (cond ((null? lis) '())   ; take the first element and then cddr(skip two)
        ((null? (cdr lis)) lis)  ; returns elements of list in odd indexes
        (else (cons (car lis) (odds (cddr lis)))))))



(define (evenrev lis)
  (if (not (list? lis))     ; Checks if parameter is a list
     "USAGE: (evenrev (list))"
 (cond ((null? lis) '())
       ((null? (cdr lis))'()) ;returns elements of list in even indexes
        (else (append (evenrev (cddr lis)) (list (cadr lis)))))))


(define (penultimate lis)
  (if (not (list? lis))    ; Checks if parameter is a list
      "USAGE: (penultimate (list))"
  (if (< (mylength lis) 2)  ; if length is less than 2
      '()
  (if (= (mylength lis) 2)  ; if length is equal to 2
        (car lis)
        (penultimate (cdr lis)))))) ; returns the second to last element
  
       

(define (palindrome lis)
  (if (not (list? lis))   ; Checks if parameter is a list
      "USAGE: (palindrome (list))"
  (cond
    ((list? lis)
     (cond
       ((null? lis) #t)
       ((null? (cdr lis)) #t) 
       ((eqv? (car lis) (reverseList (car (reverseList (cdr lis))))) 
        (palindrome(cdr(reverseList(cdr lis))))) ; strips the first and last element of lis
       (else #f))))))

(define (reverseList lis)  ; helper function reverses the list
    (cond
      ((list? lis)
       (cond
         ((null? lis) lis)
         ((null? (cdr lis)) lis)
         (else (append (reverseList (cdr lis)) (list (car lis)) )))) ; appends the elements in reverse order
      (else lis)))
        
 
(define (mylength lis)  ; helper function returns length of list
  (if (empty? lis)
      0
      (+ 1 (mylength (rest lis)))))
