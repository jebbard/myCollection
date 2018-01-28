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
import {CollectionBasicsComponent} from './collection-basics/collection-basics.component';
import {CollectionRulesComponent} from './collection-rules/collection-rules.component';
import {CollectionStatisticsComponent} from './collection-statistics/collection-statistics.component';
import {CollectionToolbarComponent} from './collection-toolbar/collection-toolbar.component';
import { AngularFilePickerModule } from 'angular-file-picker';

@NgModule({
  declarations: [
    AppComponent,
    CollectionListComponent,
    MessagesComponent,
    CollectionHeaderComponent,
    CollectionBasicsComponent,
    CollectionRulesComponent,
    CollectionStatisticsComponent,
    CollectionToolbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    AngularFilePickerModule,
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, {dataEncapsulation: false}
    )],
  providers: [CollectionService, MessageService],
  entryComponents: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
