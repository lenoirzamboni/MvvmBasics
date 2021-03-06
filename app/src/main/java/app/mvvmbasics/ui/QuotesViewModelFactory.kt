package app.mvvmbasics.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.mvvmbasics.data.QuoteRepository

class QuotesViewModelFactory(private val quoteRepository: QuoteRepository):
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}