import {Component, OnInit, Input, ViewChild, ElementRef, AfterViewInit, Output, EventEmitter} from '@angular/core';
import {CollectionView} from '../collection-list/collection-view';
import {CollectionViewMode} from '../collection-list/collection-view-mode';
import {CollectionService} from '../services/collections/collection.service';
import {Collection} from '../services/collections/collection';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-collection-form',
  templateUrl: './collection-form.component.html',
  styleUrls: ['./collection-form.component.css']
})
export class CollectionFormComponent implements OnInit, AfterViewInit {

  @Input() collectionView: CollectionView;
  @Output() addedColEvent: EventEmitter<CollectionView> = new EventEmitter<CollectionView>();
  @ViewChild('input1') inputEl: ElementRef;

  pictureOptions: string[] = [
    'ELECTRO1',
    'ROCK1',
    'MUSIC1'
  ];

  constructor(private collectionService: CollectionService) {
  }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.inputEl.nativeElement.focus();
  }

  browseCollection(): void {
    // Todo: Implement browse
    alert('Not yet implemented');
  }

  synchCollection(): void {
    const currentMode: CollectionViewMode = this.collectionView.mode;
    this.collectionView.mode = CollectionViewMode.IN_SYNCHRONIZATION;
    const timerFunction = () => this.updateSyncStatus(this.collectionView);
    const syncUpdateTimer = window.setInterval(timerFunction, 1000);
    this.collectionService.synchronizeCollection(this.collectionView.collection).subscribe(col => {
      window.clearInterval(syncUpdateTimer);
      this.collectionView.mode = currentMode;
    });
  }

  updateSyncStatus(collectionView: CollectionView): void {
    this.collectionService.getCollection(collectionView.collection.id).subscribe(col => {
      collectionView.updateCollection(col);
    });
  }

  cancelSynchCollection(): void {
    this.collectionService.cancelSynchronizeCollection(this.collectionView.collection).subscribe(col => {
      this.collectionView.mode = CollectionViewMode.VIEW;
    });
  }

  submitChanges(): void {
    if (this.collectionView.mode === CollectionViewMode.NEW) {
      this.collectionView.mode = CollectionViewMode.IN_CREATE;
      this.collectionService.addCollection(this.collectionView.collection).subscribe(col => {
        this.collectionView.saveChanges(col);
        this.addedColEvent.emit(this.collectionView);
      });
    } else if (this.collectionView.mode === CollectionViewMode.EDIT) {
      this.collectionView.mode = CollectionViewMode.IN_UPDATE;
      this.collectionService.updateCollection(this.collectionView.collection).subscribe(col => {
        this.collectionView.saveChanges(this.collectionView.collection);
      });
    } else {
      alert('ILLEGAL STATE');
    }
  }

  isBrowseButtonVisible(): boolean {
    return this.isBrowseButtonEnabled() ||
      this.collectionView.isInUpdate() || this.collectionView.isInSynchronization();
  }

  isBrowseButtonEnabled(): boolean {
    return this.collectionView.isViewed();
  }

  isSyncButtonVisible(): boolean {
    return this.isSyncButtonEnabled() ||
      this.collectionView.isInUpdate();
  }

  isSyncButtonEnabled(): boolean {
    return this.collectionView.isViewed();
  }

  isEditButtonVisible(): boolean {
    return this.isEditButtonEnabled() || this.collectionView.isInSynchronization();
  }

  isEditButtonEnabled(): boolean {
    return this.collectionView.isViewed();
  }

  isSaveButtonVisible(): boolean {
    return this.collectionView.isInUpdate();
  }

  isSaveButtonEnabled(form: NgForm): boolean {
    return this.collectionView.mode === CollectionViewMode.EDIT &&
      form.valid && form.dirty;
  }

  isCreateButtonVisible(): boolean {
    return this.collectionView.isInCreation();
  }

  isCreateButtonEnabled(form: NgForm): boolean {
    return this.collectionView.mode === CollectionViewMode.NEW &&
      form.valid && form.dirty;
  }

  isCancelButtonVisible(): boolean {
    return this.isCancelButtonEnabled();
  }

  isCancelButtonEnabled(): boolean {
    return this.collectionView.isInSynchronization();
  }

  isCloseButtonVisible(form: NgForm): boolean {
    return this.collectionView.mode === CollectionViewMode.IN_UPDATE ||
      this.collectionView.mode === CollectionViewMode.IN_SYNCHRONIZATION ||
      (this.collectionView.mode === CollectionViewMode.EDIT && !form.dirty) ||
      (this.collectionView.mode === CollectionViewMode.NEW && !form.dirty) ||
      this.collectionView.mode === CollectionViewMode.VIEW;
  }

  isCloseButtonEnabled(): boolean {
    return this.collectionView.mode === CollectionViewMode.VIEW || this.collectionView.mode === CollectionViewMode.EDIT || this.collectionView.mode === CollectionViewMode.NEW;
  }

  isDiscardButtonVisible(form: NgForm): boolean {
    return this.collectionView.mode === CollectionViewMode.IN_CREATE ||
      (this.collectionView.mode === CollectionViewMode.EDIT && form.dirty) ||
      (this.collectionView.mode === CollectionViewMode.NEW && form.dirty);
  }

  isDiscardButtonEnabled(form: NgForm): boolean {
    return this.collectionView.mode === CollectionViewMode.NEW ||
      (this.collectionView.mode === CollectionViewMode.EDIT && form.dirty);
  }
}
