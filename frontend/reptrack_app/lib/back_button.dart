import 'package:flutter/material.dart';
import 'package:reptrack_app/app_theme.dart';

class AppBackButton extends StatelessWidget {
  const AppBackButton({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(shape: BoxShape.circle, border: BoxBorder.all(color: AppColors.limeGreen)),
      
      child:IconButton(
      onPressed: () {
        Navigator.pop(context);
      },
      icon: const Icon(
        Icons.arrow_back,
        color: AppColors.limeGreen,
        size: 30,
      ),
      ),
    );
  }
}