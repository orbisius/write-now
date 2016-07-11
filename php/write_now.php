<?php

/**
 * Creates a file really quick and allows you to start writing NOW.
 * The file is prefixed by an exclamation which hints that it's a draft.
 * 
 * @author Svetoslav (SLAVI) Marinov | http://orbisius.com
 * @copyright (c) 2016 Svetoslav (SLAVI) Marinov
 */
echo "Article title: ";
$article_title = trim( fgets( STDIN ) );

$target_ext = '.docx';
$base_writing_dir = 'C:/Copy/Dropbox/Business/' . date( 'Y' ) . '/Writing';

// ! is for drafts
$article_dir = $base_writing_dir . '/!' . date('Y-m-d') . '-' . $article_title;

if ( ! is_dir( $article_dir ) ) {
    mkdir( $article_dir, 0755, 1 );
}

$article_file = "$article_dir/$article_title$target_ext";
touch( $article_file );

// Switch to Windows slashes
$article_dir4win = str_replace( '/', '\\', $article_dir );
$article_file4win = str_replace( '/', '\\', $article_file );

echo $article_file;

// Executed the default editor.
`$article_file`;

// Open the dir that this new file is in the user may want to just publish it.
// @see https://support.microsoft.com/en-us/kb/130510
`explorer /select,$article_file4win`;

