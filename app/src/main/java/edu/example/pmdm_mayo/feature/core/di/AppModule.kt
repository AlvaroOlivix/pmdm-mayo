package edu.example.pmdm_mayo.feature.core.di

import android.content.Context
import edu.example.pmdm_mayo.feature.client.data.local.ClientDao
import edu.example.pmdm_mayo.feature.client.data.remote.RemoteMockDataSource
import edu.example.pmdm_mayo.feature.core.db.ClientDataBase
import edu.example.pmdm_mayo.feature.core.db.DbProvider
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single


@Module
@ComponentScan("edu.example.pmdm_mayo")
class AppModule {

    @Single
    fun provideClientDatabase(context: Context): ClientDataBase =
        DbProvider.provideDatabase(context)

    @Single
    fun provideClienteDao(db: ClientDataBase): ClientDao {
        return db.clientDao()
    }
    @Single
    fun provideMoc():RemoteMockDataSource{
        return RemoteMockDataSource()
    }

}