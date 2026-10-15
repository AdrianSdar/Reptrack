import 'package:flutter/material.dart';
import 'package:reptrack_app/app_theme.dart';
import 'package:reptrack_app/back_button.dart';

class CreateAccountScreen extends StatelessWidget {
  const CreateAccountScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.black,
      body: Stack(
        children: [
          Positioned(
            left: 20,
            right: 20,
            top: 70,
            child: Column(
              children: [
                Image.asset('assets/images/reptrackLogo.png', width: 180),
              ],
            ),
          ),
          Positioned(
            left: 20,
            right: 20,
            top: 250,
            child: Center(
              child: SizedBox(
                width: 340,
                height: 550,
                child: Stack(
                  children: [
                    Container(
                      decoration: BoxDecoration(
                        color: AppColors.darkGrey,
                        borderRadius: BorderRadius.circular(20),
                        border: Border.all(color: AppColors.greyGreen),
                      ),
                    ),
                    Positioned(
                      left: 25,
                      right: 25,
                      top: 25,
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text("FULL NAME", style: AppTextStyles.h3),
                          SizedBox(height: 10),
                          TextField(
                            style: const TextStyle(color: AppColors.greyGreen),
                            decoration: InputDecoration(
                              hintText: "e.g John Doe",
                              enabledBorder: OutlineInputBorder(
                                borderSide: BorderSide(color: AppColors.greyGreen),
                              ),
                              focusedBorder: OutlineInputBorder(
                                borderSide: BorderSide(color: AppColors.greyGreen),
                              ),
                              hintStyle: TextStyle(
                                color: AppColors.white.withOpacity(0.3),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                    Positioned(left: 25, right: 25, top: 145, child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text("EMAIL", style: AppTextStyles.h3),
                        SizedBox(height: 10),
                        TextField(
                          decoration: InputDecoration(hintText: "e.g johndoe@gmail.com", hintStyle: TextStyle(color: AppColors.white.withOpacity(0.3)), 
                          enabledBorder: OutlineInputBorder(borderSide: BorderSide(color: AppColors.greyGreen)),
                          focusedBorder: OutlineInputBorder(borderSide: BorderSide(color: AppColors.greyGreen))
                          ),
                        ),
                      ],
                    )),
                    Positioned(left: 25, right: 25, top: 265, 
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text("PASSWORD", style: AppTextStyles.h3),
                        SizedBox(height: 10),
                        TextField(
                          decoration: InputDecoration(hintText: "••••••••", hintStyle: TextStyle(color: AppColors.white.withOpacity(0.3)),
                          enabledBorder: OutlineInputBorder(borderSide: BorderSide(color: AppColors.greyGreen)),
                          focusedBorder: OutlineInputBorder(borderSide: BorderSide(color: AppColors.greyGreen)),
                          ),
                        )
                      ],
                    )),
                    Positioned(
                      left: 25,
                      right: 25,
                      top: 400,
                      child: SizedBox(
                        width: double.infinity,
                        height: 70,
                        child: ElevatedButton(
                          onPressed: () {},
                          style: ElevatedButton.styleFrom(
                            backgroundColor: AppColors.limeGreen,
                            shape: RoundedRectangleBorder(
                              side: BorderSide(color: AppColors.black, width: 2),
                              borderRadius: BorderRadius.circular(8),
                            ),
                          ),
                          child: FittedBox(
                            fit: BoxFit.scaleDown,
                            child: Text(
                              "CREATE ACCOUNT",
                              style: AppTextStyles.h1_2,
                              maxLines: 1,
                            ),
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),
          Positioned(
            left: 20,
            right: 20,
            bottom: 70,
            child: Column(
              children: [
                AppText.precisionDisciplineResults,
              ],
            ),
          ),
          Positioned(left: 20, top: 70, 
          child: AppBackButton())
        ],
      ),
    );
  }
}