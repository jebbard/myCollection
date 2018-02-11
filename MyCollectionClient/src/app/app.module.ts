import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';
import {InMemoryDataService} from './services/in-memory-data.service';
import {AppComponent} from './app.component';
import {MessagesComponent} from './messages/messages.component';
import {MessageService} from './services/messages/message.service';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './/app-routing.module';
import {CollectionListComponent} from './collection-list/collection-list.component';
import {CollectionService} from './services/collections/collection.service';
import {CollectionHeaderComponent} from './collection-header/collection-header.component';
import { AngularFilePickerModule } from 'angular-file-picker';
import { CollectionFormComponent } from './collection-form/collection-form.component';

@NgModule({
  declarations: [
    AppComponent,
    CollectionListComponent,
    MessagesComponent,
    CollectionHeaderComponent,
    CollectionFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    AngularFilePickerModule,
    // HttpClientInMemoryWebApiModule.forRoot(
    //   InMemoryDataService, {dataEncapsulation: false, delay: 1600, passThruUnknownUrl: false}
    // )
  ],
  providers: [CollectionService, MessageService],
  entryComponents: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
