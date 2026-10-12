import 'package:flutter/material.dart';

class AppColors{
  static const limeGreen = Color(0xFFDFFF00);
  static const black = Color.fromARGB(255, 0, 0, 0);
  static const darkGrey = Color(0xFF1E1E1E);
  static const white = Color(0xFFFFFFFF);
  static const greyGreen = Color(0xFFC6C9AB);
}

class AppTextStyles{
  static const h1 = TextStyle(fontSize: 40, color: AppColors.white, fontWeight: FontWeight.bold, fontFamily: 'Montserrat-Regular');
  static const h1_2 = TextStyle(fontSize: 30, color: AppColors.black, fontWeight: FontWeight.bold, fontFamily: 'Montserrat-Regular');
  static const h2 = TextStyle(fontSize: 28, color: AppColors.white, fontWeight: FontWeight.bold, fontFamily: 'Montserrat-Regular');
  static const h3 = TextStyle(fontSize: 20, color: AppColors.greyGreen, fontWeight: FontWeight.normal, fontFamily: 'Montserrat-Regular');
  static const h3_2 = TextStyle(fontSize: 20, color: AppColors.black, fontWeight: FontWeight.normal, fontFamily: 'Montserrat-Regular');
}