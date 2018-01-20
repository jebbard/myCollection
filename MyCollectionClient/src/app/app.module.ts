import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';
import {InMemoryDataService} from './services/in-memory-data.service';
import {AppComponent} from './app.component';
import {CollectionListComponent} from './collection-list/collection-list.component';
import {CollectionService} from './services/collections/collection.service';
import {MessagesComponent} from './messages/messages.component';
import {MessageService} from './services/messages/message.service';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './/app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    CollectionListComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, {dataEncapsulation: false}
    )],
  providers: [CollectionService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
