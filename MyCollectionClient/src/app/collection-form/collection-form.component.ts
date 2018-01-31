import { Component, OnInit, Input, ViewChild, ElementRef, AfterViewInit, Output, EventEmitter } from '@angular/core';
import {CollectionView} from '../collection-list/collection-view';
import {CollectionViewMode} from '../collection-list/collection-view-mode';
import {CollectionService} from '../services/collections/collection.service';
import {Collection} from '../services/collections/collection';

@Component({
  selector: 'app-collection-form',
  templateUrl: './collection-form.component.html',
  styleUrls: ['./collection-form.component.css']
})
export class CollectionFormComponent implements OnInit, AfterViewInit {

  @Input() collectionView: CollectionView;
  @Output() addedColEvent: EventEmitter<CollectionView> = new EventEmitter<CollectionView>();
  @ViewChild('input1') inputEl: ElementRef;

  constructor(private collectionService: CollectionService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.inputEl.nativeElement.focus();
  }

  synchCollection(): void {
    this.collectionService.synchronizeCollection(this.collectionView.collection).subscribe();
  }

  submitChanges(): void {
    if (this.collectionView.mode === CollectionViewMode.NEW) {
      this.collectionService.addCollection(this.collectionView.collection).subscribe(col => this.collectionView.collectionChanged(col));
      this.collectionView.open();
      this.addedColEvent.emit(this.collectionView);
    } else if (this.collectionView.mode === CollectionViewMode.EDIT) {
      this.collectionService.updateCollection(this.collectionView.collection).subscribe(col => this.collectionView.collectionChanged(col));
    } else {
      alert('ILLEGAL STATE');
    }

    this.collectionView.save();
  }
}
