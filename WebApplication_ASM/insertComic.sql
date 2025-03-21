INSERT INTO categories (name) VALUES ('Action');
INSERT INTO categories (name) VALUES ('Adventure');
INSERT INTO categories (name) VALUES ('Fantasy');
INSERT INTO categories (name) VALUES ('Horror');
INSERT INTO categories (name) VALUES ('Romance');
INSERT INTO categories (name) VALUES ('Comedy');
INSERT INTO categories (name) VALUES ('Supernatural');
INSERT INTO categories (name) VALUES ('Historical');
INSERT INTO categories (name) VALUES ('Sports');

INSERT INTO comics (title, description, cover_image, add_admin, author, status, views, likes, favorites)
VALUES 
  ('One Piece', 'A popular manga about pirates seeking the ultimate treasure.', 'https://example.com/images/onepiece.jpg', 'admin01', 'Eiichiro Oda', 'ongoing', 1000000, 50000, 30000),
  ('Naruto', 'A story of a young ninja striving to become Hokage.', 'https://example.com/images/naruto.jpg', 'admin01', 'Masashi Kishimoto', 'completed', 800000, 40000, 25000),
  ('Bleach', 'A tale of a teenager with the power to see ghosts who becomes a Soul Reaper.', 'https://example.com/images/bleach.jpg', 'admin01', 'Tite Kubo', 'completed', 750000, 35000, 20000),
  ('Attack on Titan', 'Humans fight for survival against gigantic humanoid Titans.', 'https://example.com/images/aot.jpg', 'admin01', 'Hajime Isayama', 'completed', 1200000, 60000, 40000),
  ('My Hero Academia', 'In a world where almost everyone has superpowers, a powerless boy dreams of being a hero.', 'https://example.com/images/mha.jpg', 'admin01', 'Kōhei Horikoshi', 'ongoing', 950000, 45000, 30000),
  ('Demon Slayer: Kimetsu no Yaiba', 'A boy becomes a demon slayer to avenge his family and cure his sister.', 'https://example.com/images/demonslayer.jpg', 'admin01', 'Koyoharu Gotouge', 'completed', 1100000, 55000, 35000),
  ('Jujutsu Kaisen', 'A high school student joins a secret organization to battle cursed spirits.', 'https://example.com/images/jujutsukaisen.jpg', 'admin01', 'Gege Akutami', 'ongoing', 900000, 42000, 28000),
  ('One Punch Man', 'A hero so powerful he defeats any enemy with one punch – but he’s bored by the lack of challenge.', 'https://example.com/images/onepunchman.jpg', 'admin01', 'ONE, Yusuke Murata', 'ongoing', 850000, 40000, 27000),
  ('Dragon Ball', 'A young boy embarks on an adventure to collect mystical orbs called Dragon Balls.', 'https://example.com/images/dragonball.jpg', 'admin01', 'Akira Toriyama', 'completed', 1000000, 48000, 32000),
  ('Hunter x Hunter', 'A boy takes a rigorous exam to become a Hunter and search for his missing father.', 'https://example.com/images/hunterxhunter.jpg', 'admin01', 'Yoshihiro Togashi', 'ongoing', 780000, 37000, 22000),
  ('Fullmetal Alchemist', 'Two brothers use alchemy to search for the Philosopher''s Stone and restore their bodies.', 'https://example.com/images/fullmetalalchemist.jpg', 'admin01', 'Hiromu Arakawa', 'completed', 950000, 43000, 29000),
  ('Death Note', 'A student discovers a supernatural notebook that lets him kill anyone by writing their name.', 'https://example.com/images/deathnote.jpg', 'admin01', 'Tsugumi Ohba, Takeshi Obata', 'completed', 1020000, 50000, 34000),
  ('Tokyo Ghoul', 'A college student becomes half-ghoul after a near-fatal encounter.', 'https://example.com/images/tokyoghoul.jpg', 'admin01', 'Sui Ishida', 'completed', 870000, 41000, 26000),
  ('JoJo''s Bizarre Adventure', 'An epic saga following the adventures of the Joestar family across generations.', 'https://example.com/images/jojo.jpg', 'admin01', 'Hirohiko Araki', 'ongoing', 800000, 39000, 24000),
  ('Dorohedoro', 'A dark fantasy featuring a lizard-headed amnesiac seeking the sorcerer who transformed him.', 'https://example.com/images/dorohedoro.jpg', 'admin01', 'Q Hayashida', 'ongoing', 650000, 30000, 20000),
  ('Chainsaw Man', 'A young man merges with his pet devil to become a chainsaw-wielding fighter.', 'https://example.com/images/chainsawman.jpg', 'admin01', 'Tatsuki Fujimoto', 'ongoing', 920000, 44000, 31000),
  ('Berserk', 'A dark fantasy following a lone warrior in a brutal medieval world.', 'https://example.com/images/berserk.jpg', 'admin01', 'Kentaro Miura', 'ongoing', 770000, 36000, 25000),
  ('Vinland Saga', 'A historical epic about a young warrior in the age of Vikings.', 'https://example.com/images/vinlandsaga.jpg', 'admin01', 'Makoto Yukimura', 'ongoing', 640000, 31000, 22000),
  ('Dr. Stone', 'After humanity is petrified, a genius uses science to rebuild civilization.', 'https://example.com/images/drstone.jpg', 'admin01', 'Riichiro Inagaki', 'ongoing', 880000, 42000, 28000),
  ('Black Clover', 'A boy without magic strives to become the Wizard King in a world full of sorcery.', 'https://example.com/images/blackclover.jpg', 'admin01', 'Yūki Tabata', 'ongoing', 830000, 41000, 27000),
  ('Fairy Tail', 'Wizards form a guild and embark on magical adventures and epic battles.', 'https://example.com/images/fairytail.jpg', 'admin01', 'Hiro Mashima', 'completed', 760000, 38000, 24000),
  ('Soul Eater', 'Students at a school for weapon meisters and their living weapons battle supernatural foes.', 'https://example.com/images/souleater.jpg', 'admin01', 'Atsushi Ōkubo', 'completed', 690000, 35000, 23000),
  ('Gintama', 'A hilarious and action-packed story set in an alternate-history Edo filled with aliens.', 'https://example.com/images/gintama.jpg', 'admin01', 'Hideaki Sorachi', 'completed', 810000, 40000, 26000),
  ('Nisekoi', 'A romantic comedy about a fake relationship between heirs of rival gangs.', 'https://example.com/images/nisekoi.jpg', 'admin01', 'Naoshi Komi', 'completed', 550000, 29000, 21000),
  ('Blue Exorcist', 'A boy discovers his demonic heritage and trains to become an exorcist.', 'https://example.com/images/blueexorcist.jpg', 'admin01', 'Kazue Kato', 'ongoing', 680000, 33000, 22000),
  ('The Promised Neverland', 'Orphaned children uncover dark secrets behind their seemingly idyllic home.', 'https://example.com/images/promisedneverland.jpg', 'admin01', 'Kaiu Shirai, Posuka Demizu', 'completed', 770000, 37000, 23000),
  ('Kaguya-sama: Love is War', 'A battle of wits and unspoken feelings between two high school geniuses.', 'https://example.com/images/kaguyasama.jpg', 'admin01', 'Akasaka Aka', 'ongoing', 600000, 31000, 21000),
  ('Mob Psycho 100', 'A young psychic struggles to balance his extraordinary abilities with everyday life.', 'https://example.com/images/mobpsycho100.jpg', 'admin01', 'ONE', 'ongoing', 640000, 32000, 21000),
  ('Re:Zero − Starting Life in Another World', 'A boy is transported to a fantasy world where he relives events over and over.', 'https://example.com/images/rezero.jpg', 'admin01', 'Tappei Nagatsuki', 'ongoing', 700000, 34000, 22000),
  ('Goblin Slayer', 'A grim tale about a man dedicated to eradicating goblins at any cost.', 'https://example.com/images/goblinslayer.jpg', 'admin01', 'Kumo Kagyu', 'ongoing', 580000, 30000, 20000),
  ('The Rising of the Shield Hero', 'A man is summoned to another world to become a legendary shield hero.', 'https://example.com/images/shieldhero.jpg', 'admin01', 'Aneko Yusagi', 'ongoing', 620000, 31000, 21000),
  ('Magi: The Labyrinth of Magic', 'A fantastical adventure inspired by Arabian Nights filled with magic and dungeons.', 'https://example.com/images/magi.jpg', 'admin01', 'Shinobu Ohtaka', 'completed', 670000, 33000, 22000),
  ('The Seven Deadly Sins', 'A group of knights embarks on a quest to reclaim their lost kingdom.', 'https://example.com/images/sevendeadlysins.jpg', 'admin01', 'Nakaba Suzuki', 'completed', 750000, 36000, 24000),
  ('Seraph of the End', 'After a virus decimates humanity, survivors battle vampires for control.', 'https://example.com/images/seraphoftheend.jpg', 'admin01', 'Takaya Kagami', 'ongoing', 690000, 35000, 23000),
  ('Mushishi', 'A wandering “Mushi-shi” investigates mysterious creatures called Mushi.', 'https://example.com/images/mushishi.jpg', 'admin01', 'Yuki Urushibara', 'completed', 580000, 30000, 20000),
  ('Parasyte', 'A high school student fights for survival when parasitic creatures invade human bodies.', 'https://example.com/images/parasyte.jpg', 'admin01', 'Hitoshi Iwaaki', 'completed', 630000, 31000, 21000),
  ('Claymore', 'In a dark world, half-human warriors battle shape-shifting monsters.', 'https://example.com/images/claymore.jpg', 'admin01', 'Norihiro Yagi', 'completed', 570000, 29000, 20000),
  ('Nausicaä of the Valley of the Wind', 'A princess fights to save her post-apocalyptic world from environmental ruin.', 'https://example.com/images/nausicaa.jpg', 'admin01', 'Hayao Miyazaki', 'completed', 610000, 31000, 21000),
  ('Inuyasha', 'A modern girl travels back in time and meets a half-demon in feudal Japan.', 'https://example.com/images/inuyasha.jpg', 'admin01', 'Rumiko Takahashi', 'completed', 700000, 34000, 22000),
  ('Rurouni Kenshin', 'A reformed assassin wanders Japan, protecting the innocent.', 'https://example.com/images/rurounikenshin.jpg', 'admin01', 'Nobuhiro Watsuki', 'completed', 680000, 32000, 21000),
  ('Yu Yu Hakusho', 'A delinquent becomes a spirit detective and battles supernatural foes.', 'https://example.com/images/yuyuhakusho.jpg', 'admin01', 'Yoshihiro Togashi', 'completed', 640000, 31000, 20000),
  ('Great Teacher Onizuka', 'A former gang member becomes a teacher and inspires his troubled students.', 'https://example.com/images/gto.jpg', 'admin01', 'Tooru Fujisawa', 'completed', 600000, 30000, 19000),
  ('Golden Kamuy', 'A veteran hunts for hidden treasure in the wilds of Hokkaido.', 'https://example.com/images/goldenkamuy.jpg', 'admin01', 'Satoru Noda', 'ongoing', 570000, 28000, 18000),
  ('Assassination Classroom', 'Students plot to kill their alien teacher before time runs out.', 'https://example.com/images/assassinationclassroom.jpg', 'admin01', 'Yūsei Matsui', 'completed', 650000, 30000, 20000),
  ('Drifters', 'Historical warriors are transported to a fantastical realm to wage epic battles.', 'https://example.com/images/drifters.jpg', 'admin01', 'Kouta Hirano', 'ongoing', 580000, 29000, 21000),
  ('Kingdom', 'A story of war and ambition set in ancient China.', 'https://example.com/images/kingdom.jpg', 'admin01', 'Yasuhisa Hara', 'ongoing', 700000, 35000, 22000),
  ('Akira', 'A groundbreaking cyberpunk tale set in a post-apocalyptic Tokyo.', 'https://example.com/images/akira.jpg', 'admin01', 'Katsuhiro Otomo', 'completed', 750000, 37000, 23000),
  ('Lone Wolf and Cub', 'A samurai and his young son travel feudal Japan seeking vengeance.', 'https://example.com/images/lonewolfandcub.jpg', 'admin01', 'Kazuo Koike, Goseki Kojima', 'completed', 500000, 25000, 18000),
  ('Vagabond', 'A beautifully illustrated tale of a wandering swordsman based on Miyamoto Musashi.', 'https://example.com/images/vagabond.jpg', 'admin01', 'Takehiko Inoue', 'ongoing', 680000, 33000, 21000),
  ('Slam Dunk', 'A high school delinquent discovers a passion for basketball.', 'https://example.com/images/slamdunk.jpg', 'admin01', 'Takehiko Inoue', 'completed', 800000, 36000, 22000);
