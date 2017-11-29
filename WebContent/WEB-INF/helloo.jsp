<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Test to show all tables</title>
</head>

<body>
<h1>Albums</h1>
<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>COPYRIGHT DATE</th>
			<th>TITLE</th>
			<th>FORMAT</th>
			<th>ALBUM ID</th>
			<th>Producer</th>
			<th>Delete</th>	
				
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${albums}" var="albums">
			<tr>
			<td>${albums.id}</td>
			<td>${albums.copyrightDate}</td>
			<td>${albums.title}</td>
			<td>${albums.format}</td>
			<td>${albums.albumId}</td>
			<td>${albums.pSSN}</td>
			
			<td> <a href="DeleteAlbum?id=${albums.id}">Delete</a></td>
			
			</tr>
		
		</c:forEach>
	
	</tbody>

</table>

<form action="AddAlbum">
	<div class="form-group" method="get">
	<input type="text" class="form-control" name="title" placeholder="Enter Title" required></input>
	<input type="date" class="form-control" name="date" placeholder="Enter CopyRightDate" required></input>
	<input type="text" class="form-control" name="format" placeholder="Enter Format" required></input>
<select name='key'>    
	<c:forEach items="${musicians}" var="musicians">
        <option>${musicians.ssn}</option>
    </c:forEach>
    </select> 	
	<button type="submit">Add Album</button>
	</div>

</form>
<h1>Songs</h1>
<table border="1">
	<thead>
		<tr>
			<th>TITLE</th>
			<th>Song ID</th>
			<th>ALBUM  ID</th>
			<th>Artist</th>
			<th>Delete</th>	
			
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${songs}" var="songs">
			<tr>
			<td>${songs.title}</td>
			<td>${songs.songId}</td>
			<td>${songs.albumId}</td>
			<td>${songs.artist}	</td>
			<td><a href=DeleteSong?id=${songs.songId}>Delete</a></td>
			
			</tr>
		
		</c:forEach>
	
	</tbody>

</table>
<form action="Addsong">
	<div class="form-group" method="get">
	<input type="text" class="form-control" name="title" placeholder="Enter Title" required></input>
	<select name='key'>    
	<c:forEach items="${albums}" var="albums">
        <option>${albums.id}</option>
    </c:forEach>
    </select>
    <select name='key2'>    
	<c:forEach items="${musicians}" var="musicians">
        <option>${musicians.name}</option>
    </c:forEach>
    </select> 
    
	<button type="submit">Add Song</button>
	</div>

</form>
<h1>Musicians</h1>
<table border="1">
	<thead>
		<tr>
			<th>SSN</th>
			<th>NAME</th>
			<th>PHONE</th>
			<th>ADDRESS</th>
			<th>Delete</th>	
			
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${musicians}" var="musicians">
			<tr>
			<td>${musicians.ssn}</td>
			<td>${musicians.name}</td>
			<td>${musicians.phone}</td>
			<td>${musicians.address}</td>
			<td> <a href="DeleteMusician?id=${musicians.ssn}">Delete</a></td>
			
			</tr>
		
		</c:forEach>
	
	</tbody>

</table>
<form action="AddMusician">
	<div class="form-group" method="get">
	<input type="text" class="form-control" name="ssn" placeholder="Enter SSN" required></input>
	<input type="text" class="form-control" name="name" placeholder="Enter Name" required></input>
	<input type="text" class="form-control" name="phone" placeholder="Enter Phone" required></input>
	<input type="text" class="form-control" name="address" placeholder="Enter Address" required></input>
	<button type="submit">Add Musician</button>
	</div>

</form>
<h1>Instruments</h1>
<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>MUSICAL KEY</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${instruments}" var="instruments">
			<tr>
			<td>${instruments.id}</td>
			<td>${instruments.name}</td>
			<td>${instruments.musicalKey}</td>
			</tr>
		
		</c:forEach>
	
	</tbody> 

</table>

<h1>Songs Performed by</h1>
<table border="1">
	<thead>
		<tr>
			<th>NAME</th>
			<th>Song Title</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${performedby}" var="performedby">
			<tr>
			<td>${performedby.name}</td>
			<td>${performedby.title}</td>

			</tr>
		
		</c:forEach>
	
	</tbody> 

</table>
<h1>Instruments Played by</h1>
<table border="1">
	<thead>
		<tr>
			<th>NAME</th>
			<th>Song Title</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${Playedby}" var="Playedby">
			<tr>
			<td>${Playedby.name}</td>
			<td>${Playedby.title}</td>

			</tr>
		
		</c:forEach>
	
	</tbody> 

</table>
</body>
</html>