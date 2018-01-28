import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {CollectionView} from '../collection-list/collection-view';
import {CollectionService} from '../services/collections/collection.service';
import {Collection} from '../services/collections/collection';

@Component({
  selector: 'app-collection-header',
  templateUrl: './collection-header.component.html',
  styleUrls: ['./collection-header.component.css']
})
export class CollectionHeaderComponent implements OnInit {

  @Input() collectionView: CollectionView;
  @Output() deleteColEvent: EventEmitter<CollectionView> = new EventEmitter<CollectionView>();
  @Output() toggleColEvent: EventEmitter<CollectionView> = new EventEmitter<CollectionView>();

  constructor(private collectionService: CollectionService) { }

  ngOnInit() {
  }

  delete(): void {
    if (confirm('Do you really want to delete the collection? This will remove the index but does not delete the media files.')) {
      this.collectionService.deleteCollection(this.collectionView.collection).subscribe();
      this.deleteColEvent.emit(this.collectionView);
    }
  }

  toggleDetails(): void {
    this.toggleColEvent.emit(this.collectionView);
  }
}
