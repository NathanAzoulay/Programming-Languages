/* @author Nathan Azoulay
 * September 11, 2019
 * CS-320 Program 1b
 * This program calculates the time in minutes it takes to fill a rectangular
 * swimming pool of uniform depth given dimensions in feet
 */
 
 #include <stdlib.h>
 #include <stdio.h>
 
 
 float calcTime(float volume);

 int main(int argc, char*argv[]){
		float length,width,height,volume;
		printf("Program #1, cssc0445, Nathan Azoulay\n");
		if(argc==4){
			length = atof(argv[1]);
			width = atof(argv[2]);
			height = atof(argv[3]);
			volume = length*width*height;
			float ans = calcTime(volume);
			printf("Time to fill a swimming pool %f by %f by %f with water\ninput rate of 20 gallons per minute is %f minutes.\n", length,width,height,ans);
		} /* scans input, calls calcTime, and prints ans */
		else{
			printf("Usage: p1b length width height\n");
		} /* when user doesnt enter correct input format */
		
		return 0;
 }
 
 
 
   float calcTime(float volume){
	   return(volume*7.8/20.0);
   } /* returns ans in minutes */