/* @author Nathan Azoulay
 * September 11, 2019
 * CS-320 Program 1a
 * This program calculates the time in minutes it takes to fill a rectangular
 * swimming pool of uniform depth given dimensions in feet
 */
 
 #include <stdlib.h>
 #include <stdio.h>
 
 void getDim(float *length, float *width, float *height);
 float calcTime(float volume);
 
 int main(){
		float length,width,height,volume;
		getDim(&length,&width,&height);
		volume = length*width*height;
		float ans = calcTime(volume);
		printf("Program #1, cssc0445, Nathan Azoulay\n");
		printf("Time to fill a swimming pool %f by %f by %f with water\ninput rate of 20 gallons per minute is %f minutes.\n", length,width,height,ans);
		return 0;
 }
 
 /* function getDim takes user input of length width and height
  *	returns void
  */
  void getDim(float *length, float *width, float *height);{
		scanf("%f %f %f", length, width, height);
		return;
  }
  
  /* function calcTime takes in the volume
   * and calculates the time given formula
   * returns float
   */
   float calcTime(float volume){
	   return(volume*7.8/20.0);
   }