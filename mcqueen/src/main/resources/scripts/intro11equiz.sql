/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sm6668
 * Created: Feb 6, 2018
 */

CREATE TABLE intro11equiz(
    chapterNo int(11), 
    questionNo int(11), 
    question text, 
    choiceA varchar(1000),
    choiceB varchar(1000),
    choiceC varchar(1000),
    choiceD varchar(1000),
    choiceE varchar(1000),
    answerKey varchar(5),
    hint text
);
