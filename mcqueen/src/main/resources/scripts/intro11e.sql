/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sm6668
 * Created: Feb 6, 2018
 */

CREATE TABLE intro11e(
    chapterNo int(11), 
    questionNo int(11), 
    isCorrect bit(1) default 0,
    time timestamp default current_timestamp,
    hostname varchar(100),
    answerA bit(1) default 0,
    answerB bit(1) default 0,
    answerC bit(1) default 0,
    answerD bit(1) default 0,
    answerE bit(1) default 0,
);
