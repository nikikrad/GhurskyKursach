//package com.example.ghurskykursach.presentation.movie.youtube
//
//import android.os.Bundle
//import android.widget.Toast
//import com.example.ghurskykursach.databinding.ActivityYoutubeBinding
//import com.google.android.youtube.player.YouTubeBaseActivity
//import com.google.android.youtube.player.YouTubeInitializationResult
//import com.google.android.youtube.player.YouTubePlayer
//
//class YoutubeActivity: YouTubeBaseActivity() {
//
//    private lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener
//    private lateinit var binding: ActivityYoutubeBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityYoutubeBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val videoId = intent.extras?.get("YTVideo").toString()
//        val video = videoId.substring(videoId.length - 11, videoId.length)
//
//        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
//            override fun onInitializationSuccess(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubePlayer?,
//                p2: Boolean
//            ) {
//                p1?.loadVideo(video)
//                p1?.setFullscreen(true)
//            }
//
//            override fun onInitializationFailure(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubeInitializationResult?
//            ) {
//                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        binding.youtubePlayer.initialize(
//            "AIzaSyCF1j71oYhcrKqet9yAOlRS2LA2iz05k3E",
//            youtubePlayerInit
//        )
//    }
//}
////