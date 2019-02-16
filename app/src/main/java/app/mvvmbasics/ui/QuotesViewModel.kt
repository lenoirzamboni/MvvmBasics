package app.mvvmbasics.ui

import androidx.lifecycle.ViewModel
import app.mvvmbasics.data.Quote
import app.mvvmbasics.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}