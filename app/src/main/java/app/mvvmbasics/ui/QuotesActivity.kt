package app.mvvmbasics.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
import app.mvvmbasics.R
import app.mvvmbasics.data.Quote
import app.mvvmbasics.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()

        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer<List<Quote>> { quotes ->
            val stringBuilder = StringBuilder()
            quotes?.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            text_quotes_display.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(edit_quote.text.toString(), edit_author.text.toString())
            viewModel.addQuote(quote)
            edit_quote.setText("")
            edit_author.setText("")
        }
    }
}
