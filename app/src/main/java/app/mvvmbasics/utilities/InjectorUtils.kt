package app.mvvmbasics.utilities

import app.mvvmbasics.data.FakeDatabase
import app.mvvmbasics.data.QuoteRepository
import app.mvvmbasics.ui.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}