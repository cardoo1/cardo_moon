
package com.example.cardo_moon.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardo_moon.Home.pertemuan_2.SecondActivity
import com.example.cardo_moon.Home.pertemuan_3.ThirdActivity
import com.example.cardo_moon.Home.pertemuan_4.FourthActivity
import com.example.cardo_moon.Home.pertemuan_5.FifthActivity
import com.example.cardo_moon.Home.pertemuan_6.SixthActivity
import com.example.cardo_moon.Home.pertemuan_9.NinthActivity
import com.example.cardo_moon.Home.pertemuan_10.TenthActivity
import com.example.cardo_moon.Home.photo.PhotoAdapter
import com.example.cardo_moon.data.api.CatFactApiClient
import com.example.cardo_moon.data.api.PhotoApiClient
import com.example.cardo_moon.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity)
            .setSupportActionBar(binding.toolbar)

        (requireActivity() as AppCompatActivity)
            .supportActionBar?.title = "Home"

        // Navigasi Pertemuan 2
        binding.btnToSecond.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    SecondActivity::class.java
                )
            )
        }

        // Navigasi Pertemuan 3
        binding.btnToThird.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    ThirdActivity::class.java
                )
            )
        }

        // Navigasi Pertemuan 4
        binding.btnToFourth.setOnClickListener {

            val intent = Intent(
                requireContext(),
                FourthActivity::class.java
            ).apply {

                putExtra("name", "Politeknik Caltex Riau")
                putExtra("from", "Rumbai")
                putExtra("age", 25)

            }

            startActivity(intent)
        }

        // Navigasi Pertemuan 5
        binding.btnToFifth.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    FifthActivity::class.java
                )
            )
        }

        // Navigasi Pertemuan 6
        binding.btnToSixth.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    SixthActivity::class.java
                )
            )
        }

        // Navigasi Pertemuan 9
        binding.btnToNinth.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    NinthActivity::class.java
                )
            )
        }

        // Navigasi Pertemuan 10
        binding.btnToTenth.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    TenthActivity::class.java
                )
            )
        }

        // Tombol Refresh Cat Fact
        binding.btnRefresh.setOnClickListener {

            loadCatFact()
        }

        // Memanggil Cat Fact API
        loadCatFact()

        // Memanggil Photo API
        loadPhoto()
    }

    // Function mengambil Cat Fact
    private fun loadCatFact() {

        binding.tvCatFact.text = "Loading cat fact..."

        viewLifecycleOwner.lifecycleScope.launch {

            try {

                val response =
                    CatFactApiClient.apiService.getCatFact()

                binding.tvCatFact.text =
                    "\"${response.fact}\""

            } catch (e: Exception) {

                if (_binding != null) {

                    binding.tvCatFact.text =
                        "Gagal mengambil fakta kucing."

                }
            }
        }
    }

    // Function mengambil Photo dari Picsum
    private fun loadPhoto() {

        viewLifecycleOwner.lifecycleScope.launch {

            try {

                val photos =
                    PhotoApiClient.apiService.getPhotos()

                if (_binding != null) {

                    val adapter = PhotoAdapter(photos)

                    binding.rvGallery.adapter = adapter

                    // List Tampil Vertical
                    binding.rvGallery.layoutManager =
                        LinearLayoutManager(requireContext())

                    // List Tampil Horizontal
                    // binding.rvGallery.layoutManager =
                    //     LinearLayoutManager(
                    //         requireContext(),
                    //         LinearLayoutManager.HORIZONTAL,
                    //         false
                    //     )

                    // List Tampil Grid
                    // binding.rvGallery.layoutManager =
                    //     GridLayoutManager(requireContext(), 2)

                }

            } catch (e: Exception) {

                if (_binding != null) {

                    Toast.makeText(
                        requireContext(),
                        "Gagal memuat gambar",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null
    }
}
