export enum CollectionViewMode {
  /* Collection is closed, only header is shown */
  CLOSED = 0,
  /* Collection details are shown */
  VIEW = 1,
  /* Collection is currently edited */
  EDIT = 2,
  /* Collection is still in creation */
  NEW = 3,
  /* Collection deletion was submitted, but server did not yet return */
  IN_DELETE = 4,
  /* Collection change was submitted, but server did not yet return */
  IN_UPDATE = 5,
  /* Collection creation was submitted, but server did not yet return */
  IN_CREATE = 6,
  /* Collection synchronization was submitted, but server did not yet finish synchronization */
  IN_SYNCHRONIZATION = 7,
}
