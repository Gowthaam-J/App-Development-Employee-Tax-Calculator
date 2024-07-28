import React, { useState, useEffect } from 'react';
import '../css/AdminPage.css';
import { Button, Box, Typography, Select, MenuItem, IconButton } from '@mui/material';
import AccountBoxIcon from '@mui/icons-material/AccountBox';
import { Search, FilterList, Share } from '@mui/icons-material';
import DynamicTable from './Table'; 
import { Link } from 'react-router-dom';

const AdminPage = () => {
  const [activeCategory, setActiveCategory] = useState('employees');
  const [headers, setHeaders] = useState([]);
  const [data, setData] = useState([]);
  const [rowsPerPage, setRowsPerPage] = useState(5);
  const [page, setPage] = useState(0);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(`/data/${activeCategory}.json`);
        if (!response.ok) {
          throw new Error(`Network response was not ok: ${response.statusText}`);
        }
        const jsonData = await response.json();
        setHeaders(jsonData.headers);
        setData(jsonData.data);
      } catch (error) {
        console.error('Error fetching the data:', error);
      }
    };

    fetchData();
  }, [activeCategory]);

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  const handleCategoryChange = (category) => {
    setActiveCategory(category);
  };

  return (
    <div className='main'>
      <div className='whole'>
        <div className='left-part'>
          <div className='left-top'>
            <div className='top1'>Fiscal Net</div>
            <div className='top2'>
              <div className='profilepic'>
                <AccountBoxIcon style={{ height: '2rem', width: '2rem' }} />
              </div>
              <div className='Name'>Dave Johnson</div>
            </div>
          </div>
          <div className='left-bottom'>
            <Button variant='outlined' className='button' onClick={() => handleCategoryChange('employees')}>
              <div className='elements'>Employee</div>
            </Button>
            <Button variant='outlined' onClick={() => handleCategoryChange('allowances')}>
              <div className='elements'>Allowances</div>
            </Button>
            <Button variant='outlined' onClick={() => handleCategoryChange('deductions')}>
              <div className='elements'>Deductions</div>
            </Button>
            <Button variant='outlined'>
              <div className='elements'>Help</div>
            </Button>
            <Button variant='outlined'>
              <div className='elements'>Customer Support</div>
            </Button>
            <Button variant='outlined'>
            <Link to="/"> <div className='elements'>Log Out</div></Link>
            </Button>
          </div>
        </div>
        <div className='right-part'>
          <Box sx={{ padding: 3 }}>
            <div className="header">
              <Typography variant="h6">Hello Dave, welcome back</Typography>
              <Typography variant="h4" gutterBottom>Account Manager</Typography>
            </div>
            <Box display="flex" alignItems="center" marginBottom={2}>
              <Typography>Show</Typography>
              <Select
                value={rowsPerPage}
                onChange={handleChangeRowsPerPage}
                sx={{ marginLeft: 1, marginRight: 1 }}
              >
                <MenuItem value={5}>5</MenuItem>
                <MenuItem value={10}>10</MenuItem>
                <MenuItem value={15}>15</MenuItem>
              </Select>
              <Typography>entries</Typography>
              <Box flexGrow={1} />
              <IconButton>
                <Search />
              </IconButton>
              <IconButton>
                <FilterList />
              </IconButton>
              <IconButton>
                <Share />
              </IconButton>
            </Box>
            <DynamicTable
              headers={headers}
              data={data}
              rowsPerPage={rowsPerPage}
              page={page}
              handleChangePage={handleChangePage}
              handleChangeRowsPerPage={handleChangeRowsPerPage}
            />
          </Box>
        </div>
      </div>
    </div>
  );
};

export default AdminPage;
