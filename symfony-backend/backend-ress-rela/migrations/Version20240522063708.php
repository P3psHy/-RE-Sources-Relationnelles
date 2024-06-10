<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20240522063708 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE ressource ADD CONSTRAINT FK_939F4544E4B6E6F5 FOREIGN KEY (etat_ressource_id) REFERENCES etat_ressource (id)');
        $this->addSql('ALTER TABLE ressource ADD CONSTRAINT FK_939F45447B2F6F2F FOREIGN KEY (type_ressource_id) REFERENCES type_ressource (id)');
        $this->addSql('CREATE INDEX IDX_939F4544E4B6E6F5 ON ressource (etat_ressource_id)');
        $this->addSql('CREATE INDEX IDX_939F45447B2F6F2F ON ressource (type_ressource_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE ressource DROP FOREIGN KEY FK_939F4544E4B6E6F5');
        $this->addSql('ALTER TABLE ressource DROP FOREIGN KEY FK_939F45447B2F6F2F');
        $this->addSql('DROP INDEX IDX_939F4544E4B6E6F5 ON ressource');
        $this->addSql('DROP INDEX IDX_939F45447B2F6F2F ON ressource');
    }
}
