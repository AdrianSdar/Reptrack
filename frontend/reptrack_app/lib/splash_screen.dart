import 'package:flutter/material.dart';
import 'package:reptrack_app/app_theme.dart';
import 'package:reptrack_app/create_account_screen.dart';
import 'package:reptrack_app/login_screen.dart';

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();

  }
  class _SplashScreenState extends State<SplashScreen> {

  @override
  void initState(){
    super.initState();
    Future.delayed(const Duration(seconds: 4), () {
      Navigator.of(context).pushReplacement(MaterialPageRoute(builder: (_) => const StartPage()));
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.black,
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.max,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Image.asset('assets/images/reptrackLogo.png', width: 450,
),
          ],
        )      
      )
    );
  }
}

class StartPage extends StatelessWidget{
  const StartPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.black,
      body: Stack(
        children: [
          Positioned(left: 20, right: 20, bottom: 400,
          child: Column(
            children: [
              ElevatedButton(onPressed: () {
                Navigator.push(context, MaterialPageRoute(builder: (_) => const CreateAccountScreen()));
              },
                style: ElevatedButton.styleFrom(fixedSize: const Size(260, 120), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20),),
              backgroundColor: AppColors.limeGreen,),
              child: const Text("CREATE ACCOUNT", style: AppTextStyles.h1_2, textAlign: TextAlign.center,)),
            ],
          ) 
          ),
          Positioned(left: 20, right: 20, bottom: 250,
          child: Column(
            children: [
            ElevatedButton(onPressed: (){
              Navigator.push(context, MaterialPageRoute(builder: (_) => const LoginScreen()));
            },
            style: ElevatedButton.styleFrom(fixedSize: const Size(260, 120), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20),),
              backgroundColor: AppColors.limeGreen,),
              child: const Text("LOG IN", style: AppTextStyles.h1_2, textAlign: TextAlign.center,)),
          ],)),

          Positioned(left: 20, right: 20, top: 40,
            child: Column(
            children: [
              Image.asset('assets/images/reptrackLogo.png', width: 300,)
            ],)),

          Positioned(left: 20, right: 20, bottom: 120,
            child: Column(
              children: [
                AppText.precisionDisciplineResults,
              ]
            )
            )

        ],
      )
    );
  }
}