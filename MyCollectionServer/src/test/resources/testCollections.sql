/*
 * Collection Statistics
 */

INSERT INTO `collection_statistics`
(`id`,
`version`,
`number_of_files`,
`number_of_folders`,
`statistics_summary`,
`total_size_in_bytes`)
VALUES
(
1,
0,
10,
9,
'100 albums',
11210
);


/*
 * Collections
 */

INSERT INTO `collection`
(
`id`,
`version`,
`name`,
`picture_type`,
`root_path`,
`sync_status`,
`collection_statistics_id`
)
VALUES
(
1,
0,
'Rock',
'ROCK1',
'E:\Musik\Rock',
null,
1
);
